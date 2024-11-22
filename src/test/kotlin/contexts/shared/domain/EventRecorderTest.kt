package contexts.shared.domain

import mo.staff.contexts.shared.domain.Event
import mo.staff.contexts.shared.domain.EventRecorder
import org.junit.jupiter.api.Test

data class DummyEvent(val value: String) : Event()

class DummyEntity : EventRecorder {
    override val events: MutableList<Event> = mutableListOf()

    fun doSomething() {
        recordEvent(DummyEvent("Hello"))
    }
}

class EventRecorderTest {

    @Test
    fun `should init with no events`() {
        val entity = DummyEntity()

        val events = entity.collectEvents()

        assert(events.isEmpty())
    }

    @Test
    fun `should record event`() {
        val entity = DummyEntity()
        entity.doSomething()

        val events = entity.collectEvents()

        assert(events.size == 1)
        assert(events[0] == DummyEvent("Hello"))
    }

    @Test
    fun `should record multiple events`() {
        val entity = DummyEntity()
        entity.doSomething()
        entity.doSomething()

        val events = entity.collectEvents()

        assert(events.size == 2)
        assert(events[0] == DummyEvent("Hello"))
        assert(events[1] == DummyEvent("Hello"))
    }

    @Test
    fun `should clear events after collecting`() {
        val entity = DummyEntity()

        entity.doSomething()
        entity.collectEvents()

        assert(entity.collectEvents().isEmpty())
    }
}
