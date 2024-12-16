package mo.staff.contexts.membership.application.activate

import mo.staff.contexts.shared.application.Command

data class ActivateMemberCommand(
    val userId: String,
) : Command
