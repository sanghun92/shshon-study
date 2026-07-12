package shshon.chat.controller

import org.springframework.core.io.Resource
import org.springframework.core.io.support.ResourcePatternResolver
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import shshon.chat.controller.dto.ChatRequest
import shshon.chat.controller.dto.ChatResponse
import shshon.chat.service.ChatService

@RestController
@RequestMapping("/chat")
class ChatController(
    private val chatService: ChatService,
    resourcePatternResolver: ResourcePatternResolver,
) {

    private val systemResource: Resource = resourcePatternResolver.getResource("classpath:prompts/chat-system.st")

    @PostMapping
    fun chat(@RequestBody request: ChatRequest): ChatResponse {
        val content = chatService.chat(systemResource, request.message)
        return ChatResponse(content)
    }
}

