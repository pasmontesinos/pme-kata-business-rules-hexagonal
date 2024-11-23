package contexts.orders.domain

import mo.staff.contexts.orders.domain.OrderProduct
import mo.staff.contexts.orders.domain.OrderProductId
import mo.staff.contexts.orders.domain.OrderProductType

class OrderProductMother {

    companion object {
        fun physical(id: OrderProductId = PHYSICAL_PRODUCT_ID, type: OrderProductType = OrderProductType.PHYSICAL): OrderProduct {
            return OrderProduct(id, type)
        }

        fun book(id: OrderProductId = BOOK_PRODUCT_ID, type: OrderProductType = OrderProductType.BOOK): OrderProduct {
            return OrderProduct(id, type)
        }

        val PHYSICAL_PRODUCT_ID = OrderProductId.fromString("579c86e5-eb11-4667-a96b-4accb8ec62c1")
        val BOOK_PRODUCT_ID: OrderProductId = OrderProductId.fromString("579c86e5-eb11-4667-a96b-4accb8ec62c2")
    }
}
