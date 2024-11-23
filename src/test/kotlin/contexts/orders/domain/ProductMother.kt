package contexts.orders.domain

import java.util.UUID
import mo.staff.contexts.orders.domain.Product
import mo.staff.contexts.orders.domain.ProductType

class ProductMother {

    companion object {
        fun physical(id: UUID = PHYSICAL_PRODUCT_ID, type: ProductType = ProductType.PHYSICAL): Product {
            return Product(id, type)
        }

        val PHYSICAL_PRODUCT_ID = UUID.fromString("579c86e5-eb11-4667-a96b-4accb8ec62c1")
    }
}
