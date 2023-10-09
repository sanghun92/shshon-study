package com.shshon.customers.api.dto

import com.shshon.customers.service.dto.CustomerRegisterCommand
import kotlinx.serialization.Serializable

@Serializable
data class CustomerRegisterRequest(
    val name: String
) {
    fun toCommand(): CustomerRegisterCommand {
        return CustomerRegisterCommand(
            name = this.name,
        )
    }
}
