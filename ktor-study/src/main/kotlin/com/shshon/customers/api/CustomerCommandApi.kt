package com.shshon.customers.api

import com.shshon.config.ktor.ext.respondCreated
import com.shshon.customers.api.dto.CustomerRegisterRequest
import com.shshon.customers.service.CustomerRegisterService
import com.shshon.customers.use_case.GetCustomerUseCase
import com.shshon.plugins.Api
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

class CustomerCommandApi(
    private val getCustomerUseCase: GetCustomerUseCase,
    private val customerRegisterService: CustomerRegisterService,
): Api({
    route("/customers") {
        get("/{id}") {
            val id: String by call.parameters
            call.respond(getCustomerUseCase.get(id = id))
        }

        post {
            val request = call.receive<CustomerRegisterRequest>()
            val customerId = customerRegisterService.register(command = request.toCommand())
            call.respondCreated(id = customerId)
        }
    }
})
