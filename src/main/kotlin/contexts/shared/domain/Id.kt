package mo.staff.contexts.shared.domain

import java.util.UUID

data class Id(val value: UUID) {
    override fun toString(): String {
        return value.toString()
    }

    companion object {
        fun fromString(id: String): Id {
            return Id(UUID.fromString(id))
        }

        fun random(): Id {
            return Id(UUID.randomUUID())
        }
    }
}
