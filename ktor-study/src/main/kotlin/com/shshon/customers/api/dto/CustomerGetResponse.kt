package com.shshon.customers.api.dto

import com.shshon.customers.domain.Customer
import kotlinx.serialization.Serializable

@Serializable
data class CustomerGetResponse(
    val id: String,
    val name: String
) {
    companion object {
        fun of(customer: Customer): CustomerGetResponse {
            return CustomerGetResponse(
                id = customer.id,
                name = customer.name,
            )
        }
    }
}
