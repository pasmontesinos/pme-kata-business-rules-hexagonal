package mo.staff.contexts.orders.domain

import mo.staff.contexts.shared.domain.Id

data class OrderId(val value: Id) {
    override fun toString(): String {
        return value.toString()
    }

    companion object {
        fun random(): OrderId {
            return OrderId(Id.random())
        }

        fun fromString(id: String): OrderId {
            return OrderId(Id.fromString(id))
        }
    }
}
