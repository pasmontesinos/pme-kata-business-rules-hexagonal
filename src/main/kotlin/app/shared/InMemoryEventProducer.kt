package mo.staff.app.shared

import mo.staff.contexts.shared.domain.Event
import mo.staff.contexts.shared.domain.EventProducer

class InMemoryEventProducer : EventProducer {
    override fun publish(events: List<Event>) {
    }
}
