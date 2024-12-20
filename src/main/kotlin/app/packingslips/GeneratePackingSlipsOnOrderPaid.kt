package mo.staff.app.packingslips

import mo.staff.contexts.packingslips.application.generate.GeneratePackingSlips
import mo.staff.contexts.packingslips.application.generate.GeneratePackingSlipsCommand
import mo.staff.mo.staff.app.packingslips.PackingSlipsOrderPaid

class GeneratePackingSlipsOnOrderPaid(private val generatePackingSlips: GeneratePackingSlips) {
    fun handle(orderPaid: PackingSlipsOrderPaid) {
        val generatePackingSlipsCommand = GeneratePackingSlipsCommand(
            orderId = orderPaid.orderId,
            physicalProducts = orderPaid.physicalProducts,
            bookProducts = orderPaid.bookProducts,
        )
        generatePackingSlips.execute(generatePackingSlipsCommand)
    }
}
