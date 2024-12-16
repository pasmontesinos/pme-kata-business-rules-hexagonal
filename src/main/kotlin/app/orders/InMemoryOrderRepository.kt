package mo.staff.app.orders

import mo.staff.contexts.orders.domain.Order
import mo.staff.contexts.orders.domain.OrderId
import mo.staff.contexts.orders.domain.OrderRepository

class InMemoryOrderRepository : OrderRepository {
    private val orders = mutableMapOf<String, Order>()

    override fun find(orderId: OrderId): Order? {
        return orders[orderId.toString()]
    }

    override fun save(order: Order) {
        orders[order.id.toString()] = order
    }
}
