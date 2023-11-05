package com.shshon.esstudy.product.presentation.dto

import com.shshon.esstudy.product.service.dto.ProductRegisterCommand

data class RegisterProductRequest(
    val name: String,
    val price: Int,
    val stock: Int,
) {
    fun toCommand(): ProductRegisterCommand {
        return ProductRegisterCommand(
            name = this.name,
            price = this.price,
            stock = this.stock,
        )
    }
}
