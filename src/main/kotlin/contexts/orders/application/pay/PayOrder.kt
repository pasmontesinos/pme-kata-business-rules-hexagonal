package mo.staff.contexts.orders.application.pay

import mo.staff.contexts.orders.domain.OrderDoesNotExist
import mo.staff.contexts.orders.domain.OrderId
import mo.staff.contexts.orders.domain.OrderRepository
import mo.staff.contexts.shared.domain.EventProducer

data class PayOrderRequest(val orderId: String)

class PayOrder(private val orderRepository: OrderRepository, private val eventProducer: EventProducer) {
    fun execute(payOrderRequest: PayOrderRequest) {
        val orderId: OrderId = OrderId.fromString(payOrderRequest.orderId)
        val order = orderRepository.find(orderId) ?: throw OrderDoesNotExist()

        order.pay()
        orderRepository.save(order)
        eventProducer.publish(order.collectEvents())
    }
}
