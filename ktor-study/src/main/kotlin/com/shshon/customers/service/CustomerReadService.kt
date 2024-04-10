package com.shshon.customers.service

import com.shshon.customers.domain.Customer
import com.shshon.customers.domain.repository.CustomerRepository

class CustomerReadService(
    private val customerRepository: CustomerRepository,
) {

    fun getById(id: String): Customer? {
        return null
    }
}
