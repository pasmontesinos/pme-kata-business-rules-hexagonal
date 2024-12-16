package mo.staff.contexts.members.domain

import mo.staff.contexts.shared.domain.Id

data class MemberId(val value: Id) {
    override fun toString(): String {
        return value.toString()
    }

    companion object {
        fun random(): MemberId {
            return MemberId(Id.random())
        }

        fun fromString(value: String): MemberId {
            return MemberId(Id.fromString(value))
        }
    }
}
