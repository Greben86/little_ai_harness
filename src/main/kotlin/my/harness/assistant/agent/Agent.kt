package my.harness.assistant.agent

import org.springframework.ai.chat.messages.AssistantMessage
import org.springframework.ai.chat.model.ChatModel
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.stereotype.Service

@Service
class Agent(private val chatModel: ChatModel) {

    val SYSTEM_PROMPT: String = """
            You are Harness, a coding agent that works in a local repository.
            Answer concisely.
            """.trimIndent()

    private val conversation: Conversation = Conversation(SYSTEM_PROMPT)

    fun run(userMessage: String): String {
        conversation.addUserMessage(userMessage)
        val assistantMessage: AssistantMessage =
            chatModel.call(Prompt(conversation.toPromptMessages())).result!!.output
        conversation.addAssistantMessage(assistantMessage)
        return assistantMessage.text!!
    }
}