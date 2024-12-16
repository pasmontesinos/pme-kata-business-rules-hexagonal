package mo.staff.contexts.members.domain

interface MemberRepository {
    fun save(member: Member)
}
