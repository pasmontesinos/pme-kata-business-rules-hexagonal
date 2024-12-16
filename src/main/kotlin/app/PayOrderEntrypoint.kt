package mo.staff.app

import mo.staff.app.orders.OrdersContainer
import mo.staff.contexts.orders.application.pay.PayOrder
import mo.staff.contexts.orders.application.pay.PayOrderCommand

class PayOrderEntrypoint {
    fun payOrder(orderId: String) {
        val payOrderCommand = PayOrderCommand(
            orderId = orderId,
        )

        val payOrder = OrdersContainer().get(PayOrder::class)

        payOrder.execute(payOrderCommand)
    }
}
