package com.shshon.esstudy.product.service.dto

import com.shshon.esstudy.product.domain.Product

data class ProductRegisterCommand(
    val name: String,
    val price: Int,
    val stock: Int,
) {
    fun toDomain(): Product {
        return Product.create(
            name = this.name,
            price = this.price,
            stock = this.stock,
        )
    }
}
