package mo.staff.contexts.members.application.activate

import mo.staff.contexts.shared.application.Command

data class ActivateMemberCommand(
    val userId: String,
) : Command
