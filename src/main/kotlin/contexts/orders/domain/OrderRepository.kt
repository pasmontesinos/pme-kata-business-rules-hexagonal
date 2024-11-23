package mo.staff.contexts.orders.domain

import java.util.UUID

interface OrderRepository {
    fun find(orderId: UUID): Order?
    fun save(order: Order)
}
