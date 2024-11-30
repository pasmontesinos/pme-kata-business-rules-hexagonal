package mo.staff.contexts.packingslips.application.generate

import mo.staff.contexts.shared.application.Command

data class GeneratePackingSlipsCommand(
    val orderId: String,
    val physicalProducts: List<String>,
    val booksProducts: List<String>,
) : Command
