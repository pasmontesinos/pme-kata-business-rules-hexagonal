package contexts.orders.application.pay

import contexts.orders.domain.OrderMother
import contexts.orders.domain.OrderProductMother
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import mo.staff.contexts.orders.application.pay.PayOrder
import mo.staff.contexts.orders.application.pay.PayOrderRequest
import mo.staff.contexts.orders.domain.OrderDoesNotExist
import mo.staff.contexts.orders.domain.OrderId
import mo.staff.contexts.orders.domain.OrderPaid
import mo.staff.contexts.orders.domain.OrderRepository
import mo.staff.contexts.shared.domain.EventProducer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertTrue

class PayOrderTest {

    private lateinit var orderRepository: OrderRepository
    private lateinit var eventProducer: EventProducer
    private lateinit var payOrder: PayOrder

    @BeforeEach
    fun setUp() {
        orderRepository = mockk<OrderRepository>(relaxed = true)
        eventProducer = mockk<EventProducer>(relaxed = true)
        payOrder = PayOrder(orderRepository, eventProducer)
    }

    @Test
    fun `should pay an order`() {
        val order = OrderMother.create(ORDER_ID)
        every { orderRepository.find(ORDER_ID) } returns order

        payOrder.execute(PayOrderRequest(ORDER_ID.toString()))

        assertTrue(order.isPaid())
    }

    @Test
    fun `should save the order after paying`() {
        val order = OrderMother.create(ORDER_ID)
        every { orderRepository.find(ORDER_ID) } returns order

        payOrder.execute(PayOrderRequest(ORDER_ID.toString()))

        verify { orderRepository.save(order) }
    }

    @Test
    fun `should publish the order paid event`() {
        val order = OrderMother.create(ORDER_ID)
        every { orderRepository.find(ORDER_ID) } returns order

        payOrder.execute(PayOrderRequest(ORDER_ID.toString()))

        val expectedEvent = OrderPaid(
            orderId = ORDER_ID.toString(),
            physicalProducts = listOf(OrderProductMother.PHYSICAL_PRODUCT_ID.toString()),
            bookProducts = listOf(OrderProductMother.BOOK_PRODUCT_ID.toString()),
        )

        verify {
            eventProducer.publish(listOf(expectedEvent))
        }
    }

    @Test
    fun `should raise an exception when order does not exist`() {
        every { orderRepository.find(ORDER_ID) } returns null

        assertThrows<OrderDoesNotExist> {
            payOrder.execute(PayOrderRequest(ORDER_ID.toString()))
        }

        verify(exactly = 0) {
            orderRepository.save(any())
            eventProducer.publish(any())
        }
    }

    companion object {
        private val ORDER_ID = OrderId.random()
    }
}
