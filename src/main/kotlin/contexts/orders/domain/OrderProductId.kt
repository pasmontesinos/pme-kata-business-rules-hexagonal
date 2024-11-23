package mo.staff.contexts.orders.domain

import mo.staff.contexts.shared.domain.Id

data class OrderProductId(val value: Id) {
    override fun toString(): String {
        return value.toString()
    }

    companion object {
        fun random(): OrderProductId {
            return OrderProductId(Id.random())
        }

        fun fromString(value: String): OrderProductId {
            return OrderProductId(Id.fromString(value))
        }
    }
}
