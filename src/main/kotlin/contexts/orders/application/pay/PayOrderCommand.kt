package mo.staff.contexts.orders.application.pay

import mo.staff.contexts.shared.application.Command

data class PayOrderCommand(val orderId: String) : Command
