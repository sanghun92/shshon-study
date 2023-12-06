package com.shshon.esstudy.product.domain

import com.shshon.esstudy.common.domain.Auditor
import java.util.UUID

data class Product(
    val id: String,
    val name: String,
    val price: Int,
    val stock: Int,
    val grade: ProductGrade,
    val creator: Auditor,
    val modifier: Auditor,
) {
    companion object {

        fun create(name: String, price: Int, stock: Int, grade: ProductGrade, creator: Auditor): Product {
            return Product(
                id = UUID.randomUUID().toString(),
                name = name,
                price = price,
                stock = stock,
                grade = grade,
                creator = creator,
                modifier = creator,
            )
        }
    }
}
