package com.shshon.esstudy.product.domain

import java.util.UUID

data class Product(
    val id: String,
    val name: String,
    val price: Int,
    val stock: Int,
) {
    companion object {

        fun create(name: String, price: Int, stock: Int): Product {
            return Product(
                id = UUID.randomUUID().toString(),
                name = name,
                price = price,
                stock = stock,
            )
        }
    }
}
