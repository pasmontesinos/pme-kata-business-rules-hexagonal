package mo.staff.contexts.orders.domain

import mo.staff.contexts.shared.domain.Event
import mo.staff.contexts.shared.domain.EventRecorder

class Order(val id: OrderId, private var status: OrderStatus = OrderStatus.CONFIRMED, private val products: List<OrderProduct>) : EventRecorder {
    override val events: MutableList<Event> = mutableListOf()

    fun pay() {
        status = OrderStatus.PAID
        recordEvent(
            OrderPaid(
                id.toString(),
                getPhysicalProducts().map { it.id.toString() },
                getBookProducts().map { it.id.toString() },
            ),
        )
    }

    fun isPaid(): Boolean = status == OrderStatus.PAID

    private fun getPhysicalProducts(): List<OrderProduct> {
        return products.filter { it.type == OrderProductType.PHYSICAL }
    }

    private fun getBookProducts(): List<OrderProduct> {
        return products.filter { it.type == OrderProductType.BOOK }
    }
}

enum class OrderStatus {
    CONFIRMED,
    PAID,
}
