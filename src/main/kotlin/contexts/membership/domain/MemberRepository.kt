package mo.staff.contexts.membership.domain

interface MemberRepository {
    fun save(member: Member)
}
