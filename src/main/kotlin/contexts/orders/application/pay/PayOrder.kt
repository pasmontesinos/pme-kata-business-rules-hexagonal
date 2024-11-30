package mo.staff.contexts.orders.application.pay

import mo.staff.contexts.orders.domain.OrderDoesNotExist
import mo.staff.contexts.orders.domain.OrderId
import mo.staff.contexts.orders.domain.OrderRepository
import mo.staff.contexts.shared.application.CommandAction
import mo.staff.contexts.shared.domain.EventProducer

class PayOrder(private val orderRepository: OrderRepository, private val eventProducer: EventProducer) : CommandAction<PayOrderCommand> {
    override fun execute(command: PayOrderCommand) {
        val orderId: OrderId = OrderId.fromString(command.orderId)
        val order = orderRepository.find(orderId) ?: throw OrderDoesNotExist()

        order.pay()

        orderRepository.save(order)
        eventProducer.publish(order.collectEvents())
    }
}
