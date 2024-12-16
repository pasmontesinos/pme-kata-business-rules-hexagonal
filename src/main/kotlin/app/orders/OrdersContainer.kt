package mo.staff.app.orders

import mo.staff.app.shared.InMemoryEventProducer
import mo.staff.contexts.orders.application.pay.PayOrder
import kotlin.reflect.KClass

class OrdersContainer {
    private fun provideOrderRepository() = InMemoryOrderRepository()

    private fun provideEventProducer() = InMemoryEventProducer()

    private fun providePayOrder() = PayOrder(
        orderRepository = provideOrderRepository(),
        eventProducer = provideEventProducer(),
    )

    fun <T : Any> get(clazz: KClass<T>): T {
        when (clazz) {
            PayOrder::class -> return providePayOrder() as T
            else -> throw IllegalArgumentException("Class $clazz not found")
        }
    }
}
