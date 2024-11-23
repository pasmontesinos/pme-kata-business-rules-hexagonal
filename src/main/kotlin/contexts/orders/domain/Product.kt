package mo.staff.contexts.orders.domain

import java.util.UUID

data class Product(val id: UUID, val type: ProductType)

enum class ProductType {
    PHYSICAL,
}
