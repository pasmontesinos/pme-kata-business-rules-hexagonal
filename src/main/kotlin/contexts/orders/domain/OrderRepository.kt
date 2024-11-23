package mo.staff.contexts.orders.domain

interface OrderRepository {
    fun find(orderId: OrderId): Order?
    fun save(order: Order)
}
