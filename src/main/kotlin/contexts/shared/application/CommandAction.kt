package mo.staff.contexts.shared.application

interface CommandAction<T : Command> {
    fun execute(command: T)
}