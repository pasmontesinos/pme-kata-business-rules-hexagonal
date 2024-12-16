package mo.staff.contexts.members.application.activate

import mo.staff.contexts.members.domain.Member
import mo.staff.contexts.members.domain.MemberRepository
import mo.staff.contexts.shared.application.CommandAction

class ActivateMember(private val memberRepository: MemberRepository) : CommandAction<ActivateMemberCommand> {
    override fun execute(command: ActivateMemberCommand) {
        val member = Member.activate(command.userId)
        memberRepository.save(member)
    }
}
