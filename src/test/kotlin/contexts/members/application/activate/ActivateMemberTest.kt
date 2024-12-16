package contexts.members.application.activate

import io.mockk.mockk
import io.mockk.verify
import mo.staff.contexts.members.application.activate.ActivateMember
import mo.staff.contexts.members.application.activate.ActivateMemberCommand
import mo.staff.contexts.members.domain.Member
import mo.staff.contexts.members.domain.MemberRepository
import mo.staff.contexts.shared.domain.Id
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ActivateMemberTest {

    private lateinit var memberRepository: MemberRepository
    private lateinit var activateMember: ActivateMember

    @BeforeEach
    fun setUp() {
        memberRepository = mockk<MemberRepository>(relaxed = true)
        activateMember = ActivateMember(memberRepository)
    }

    @Test
    fun `should activate membership for user`() {
        val command = ActivateMemberCommand(USER_ID)

        activateMember.execute(command)

        verify(exactly = 1) {
            memberRepository.save(
                match<Member> {
                    it.userId == USER_ID &&
                        it.level == Member.Level.BASIC &&
                        it.status == Member.Status.ACTIVE
                },
            )
        }
    }

    companion object {
        private val USER_ID = Id.random().toString()
    }
}
