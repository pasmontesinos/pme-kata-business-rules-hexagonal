package contexts.orders.domain

import mo.staff.contexts.orders.domain.Order
import mo.staff.contexts.orders.domain.OrderId
import mo.staff.contexts.orders.domain.OrderStatus
import mo.staff.contexts.orders.domain.Product

class OrderMother {

    companion object {
        fun create(id: OrderId = OrderId.random(), products: List<Product> = listOf(ProductMother.physical())): Order {
            return Order(id, OrderStatus.CONFIRMED, ProductMother.physical())
        }
    }
}
