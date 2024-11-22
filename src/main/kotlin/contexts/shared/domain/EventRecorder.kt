package mo.staff.contexts.shared.domain

interface EventRecorder {
    val events: MutableList<Event>

    fun recordEvent(event: Event) {
        events.add(event)
    }

    fun collectEvents(): List<Event> {
        val events = events.toList()
        this.events.clear()
        return events
    }
}