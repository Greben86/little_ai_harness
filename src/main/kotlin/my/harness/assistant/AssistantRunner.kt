package my.harness.assistant

import my.harness.assistant.agent.Agent
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("!test")
class AssistantRunner(private val agent: Agent): CommandLineRunner {

    override fun run(vararg args: String) =
        println(agent.run("Кто ты? Ответь развернуто."))
}