package contexts.packingslips.domain

import mo.staff.contexts.orders.domain.OrderId
import mo.staff.contexts.packingslips.domain.PackingSlip
import mo.staff.contexts.packingslips.domain.PackingSlipId

class PackingSlipMother {

    companion object {
        fun create(id: PackingSlipId = PackingSlipId.random(), orderId: String, type: PackingSlip.Type = PackingSlip.Type.SHIPPING, productIds: List<String> = listOf()): PackingSlip {
            return PackingSlip(id, type, orderId, productIds)
        }

        fun shipping(id: PackingSlipId = PackingSlipId.random(), orderId: String, productIds: List<String> = listOf()): PackingSlip {
            return create(id, orderId, PackingSlip.Type.SHIPPING, productIds)
        }
    }

}
