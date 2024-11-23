package contexts.orders.domain

import mo.staff.contexts.orders.domain.Order
import mo.staff.contexts.orders.domain.OrderId
import mo.staff.contexts.orders.domain.OrderProduct
import mo.staff.contexts.orders.domain.OrderStatus

class OrderMother {

    companion object {
        fun create(id: OrderId = OrderId.random(), products: List<OrderProduct> = listOf(OrderProductMother.physical())): Order {
            return Order(id, OrderStatus.CONFIRMED, listOf(OrderProductMother.physical(), OrderProductMother.book()))
        }
    }
}
