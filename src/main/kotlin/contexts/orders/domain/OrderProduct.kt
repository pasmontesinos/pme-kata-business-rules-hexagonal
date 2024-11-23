package mo.staff.contexts.orders.domain

data class OrderProduct(val id: OrderProductId, val type: OrderProductType)

enum class OrderProductType {
    PHYSICAL,
    BOOK,
}
