package com.shshon.customers.domain.repository

import com.shshon.customers.domain.Customer

class MockCustomerRepository : CustomerRepository {
    private val customers = mutableListOf<Customer>()

    override suspend fun save(customer: Customer): Customer {
        customers.add(customer)
        return customer
    }

    override suspend fun findById(id: String): Customer? {
        return customers.firstOrNull { it.id == id }
    }
}
