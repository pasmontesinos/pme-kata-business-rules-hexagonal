package mo.staff.contexts.packingslips.domain


class PackingSlip(val packingSlipId: PackingSlipId, val type: Type, val orderId: String, val productIds: List<String>) {

    enum class Type {
        SHIPPING,
    }
}
