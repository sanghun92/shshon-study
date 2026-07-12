package shshon.chat.service

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.model.ChatModel
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class ChatService(
    private val chatModel: ChatModel
) {

    fun chat(
        systemResource: Resource,
        userMessage: String,
    ): String? {
        return ChatClient.create(chatModel)
            .prompt()
            .system { it.text(systemResource, Charsets.UTF_8) }
            .user(userMessage)
            .call()
            .content()
    }
}
