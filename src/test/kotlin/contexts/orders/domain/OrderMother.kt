package contexts.orders.domain

import java.util.UUID
import mo.staff.contexts.orders.domain.Order
import mo.staff.contexts.orders.domain.OrderStatus
import mo.staff.contexts.orders.domain.Product

class OrderMother {

    companion object {
        fun create(id: UUID = UUID.randomUUID(), products: List<Product> = listOf(ProductMother.physical())): Order {
            return Order(id, OrderStatus.CONFIRMED, ProductMother.physical())
        }
    }
}
