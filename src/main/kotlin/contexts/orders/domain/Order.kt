package mo.staff.contexts.orders.domain

import java.util.UUID
import mo.staff.contexts.shared.domain.Event
import mo.staff.contexts.shared.domain.EventRecorder

class Order(val id: UUID, private var status: OrderStatus = OrderStatus.CONFIRMED, val product: Product) : EventRecorder {
    fun pay() {
        status = OrderStatus.PAID
        recordEvent(
            OrderPaid(id.toString(), listOf(product.id.toString()))
        )
    }

    fun isPaid(): Boolean = status == OrderStatus.PAID

    override val events: MutableList<Event> = mutableListOf()
}

enum class OrderStatus {
    CONFIRMED,
    PAID,
}
