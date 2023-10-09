package com.shshon.config.ktor.ext

import com.shshon.common.api.dto.CreatedResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

suspend inline fun <reified T> ApplicationCall.respondCreated(id: T? = null) {
    response.status(HttpStatusCode.Created)
    respondNullable(message = CreatedResponse(id = id))
}
