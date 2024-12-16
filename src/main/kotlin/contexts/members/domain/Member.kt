package mo.staff.contexts.members.domain

class Member(val memberId: MemberId, val userId: String, val level: Level, val status: Status) {

    enum class Level {
        BASIC,
    }

    enum class Status {
        ACTIVE,
    }

    companion object {
        fun activate(userId: String): Member {
            return Member(MemberId.random(), userId, Level.BASIC, Status.ACTIVE)
        }
    }
}
