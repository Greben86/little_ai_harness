package my.harness.assistant.agent

import org.springframework.ai.chat.messages.AssistantMessage
import org.springframework.ai.chat.messages.Message
import org.springframework.ai.chat.messages.SystemMessage
import org.springframework.ai.chat.messages.UserMessage

class Conversation(private val systemPrompt: String) {
    var messages: MutableList<Message> = ArrayList()

    fun addUserMessage(userMessage: String) = messages.add(UserMessage(userMessage))

    fun addAssistantMessage(assistantMessage: AssistantMessage) = messages.add(assistantMessage)

    fun toPromptMessages(): MutableList<Message> {
        val prompt = ArrayList<Message>(messages.size + 1)
        prompt.add(SystemMessage(systemPrompt))
        prompt.addAll(messages)
        return prompt
    }

}
