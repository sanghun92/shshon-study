package com.shshon.customers.service

import com.shshon.customers.domain.repository.CustomerRepository
import com.shshon.customers.service.dto.CustomerRegisterCommand

class CustomerRegisterService(
    private val customerRepository: CustomerRepository,
) {
    fun register(command: CustomerRegisterCommand): String {
        val customer = this.customerRepository.save(command.toDomain())
        return customer.id
    }
}
