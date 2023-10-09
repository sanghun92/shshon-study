package com.shshon.common.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class CreatedResponse<T>(
    val id: T?
)
