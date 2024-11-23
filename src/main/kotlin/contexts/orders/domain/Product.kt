package mo.staff.contexts.orders.domain

data class Product(val id: ProductId, val type: ProductType)

enum class ProductType {
    PHYSICAL,
}
