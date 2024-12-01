package mo.staff.contexts.packingslips.domain

class PackingSlip(val packingSlipId: PackingSlipId, val type: Type, val orderId: String, val productIds: List<String>) {

    enum class Type {
        SHIPPING,
        ROYALTY,
    }

    companion object {
        fun create(type: Type, orderId: String, physicalProducts: List<String>): PackingSlip {
            return PackingSlip(PackingSlipId.random(), type, orderId, physicalProducts)
        }
    }
}
