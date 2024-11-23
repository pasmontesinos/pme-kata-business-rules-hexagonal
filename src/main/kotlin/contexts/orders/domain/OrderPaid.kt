package mo.staff.contexts.orders.domain

import mo.staff.contexts.shared.domain.Event

data class OrderPaid(val orderId: String, val physicalProducts: List<String>, val bookProducts: List<String>) : Event()
