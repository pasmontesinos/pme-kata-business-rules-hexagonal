package mo.staff.contexts.shared.domain

interface EventProducer {
    fun publish(events: List<Event>)
}
