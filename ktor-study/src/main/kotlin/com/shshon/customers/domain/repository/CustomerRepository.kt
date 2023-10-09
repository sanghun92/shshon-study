package com.shshon.customers.domain.repository

import com.shshon.customers.domain.Customer

interface CustomerRepository {
    suspend fun save(customer: Customer) : Customer?
    suspend fun findById(id: String): Customer?
}
