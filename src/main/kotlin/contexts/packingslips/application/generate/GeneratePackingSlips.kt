package mo.staff.contexts.packingslips.application.generate

import mo.staff.contexts.packingslips.domain.PackingSlipRepository
import mo.staff.contexts.shared.application.CommandAction

class GeneratePackingSlips(private val packingSlipRepository: PackingSlipRepository) : CommandAction<GeneratePackingSlipsCommand> {
    override fun execute(command: GeneratePackingSlipsCommand) {

    }
}