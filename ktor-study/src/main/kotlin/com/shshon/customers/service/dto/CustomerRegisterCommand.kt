package com.shshon.customers.service.dto

import com.shshon.customers.domain.Customer
import java.util.UUID

data class CustomerRegisterCommand(
    val name: String
) {
    fun toDomain(): Customer {
        return Customer(
            id = UUID.randomUUID().toString(),
            name = this.name,
        )
    }
}
