package mo.staff.contexts.orders.domain

import mo.staff.contexts.shared.domain.Id

data class ProductId(val value: Id) {
    override fun toString(): String {
        return value.toString()
    }

    companion object {
        fun random(): ProductId {
            return ProductId(Id.random())
        }

        fun fromString(id: String): ProductId {
            return ProductId(Id.fromString(id))
        }
    }
}
