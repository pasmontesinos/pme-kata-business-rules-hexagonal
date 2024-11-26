package mo.staff.contexts.packingslips.domain

import mo.staff.contexts.shared.domain.Id

data class PackingSlipId(val value: Id) {
    override fun toString(): String {
        return value.toString()
    }

    companion object {
        fun random(): PackingSlipId {
            return PackingSlipId(Id.random())
        }

        fun fromString(value: String): PackingSlipId {
            return PackingSlipId(Id.fromString(value))
        }
    }
}
