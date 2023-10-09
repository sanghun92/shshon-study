package com.shshon.customers.use_case

import com.shshon.customers.api.dto.CustomerGetResponse
import com.shshon.customers.service.CustomerReadService

class GetCustomerUseCase(
    private val customerReadService: CustomerReadService
) {

    fun get(id: String): CustomerGetResponse {
        val customer = customerReadService.getById(id = id)
            ?: throw IllegalArgumentException("")
        return CustomerGetResponse.of(customer = customer)
    }
}
