package my.harness.assistant

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Profile

@SpringBootApplication
class AssistantApplication

fun main(args: Array<String>) {
	runApplication<AssistantApplication>(*args)
}
