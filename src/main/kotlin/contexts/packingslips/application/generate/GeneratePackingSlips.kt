package mo.staff.contexts.packingslips.application.generate

import mo.staff.contexts.packingslips.domain.PackingSlip
import mo.staff.contexts.packingslips.domain.PackingSlipRepository
import mo.staff.contexts.shared.application.CommandAction

class GeneratePackingSlips(private val packingSlipRepository: PackingSlipRepository) : CommandAction<GeneratePackingSlipsCommand> {
    override fun execute(command: GeneratePackingSlipsCommand) {
        val shippingProducts = command.physicalProducts + command.bookProducts
        val packingSlip = PackingSlip.create(PackingSlip.Type.SHIPPING, command.orderId, shippingProducts)
        packingSlipRepository.save(packingSlip)

        if (command.bookProducts.isNotEmpty()) {
            val royaltyPackingSlip = PackingSlip.create(PackingSlip.Type.ROYALTY, command.orderId, command.bookProducts)
            packingSlipRepository.save(royaltyPackingSlip)
        }
    }
}
