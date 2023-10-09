package com.shshon.customers.use_case

import com.shshon.customers.api.dto.CustomerRegisterRequest
import com.shshon.customers.service.CustomerRegisterService

class RegisterCustomerUseCase(
    private val customerRegisterService: CustomerRegisterService
) {

    fun register(request: CustomerRegisterRequest): String {
        return customerRegisterService.register(command = request.toCommand())
    }
}
