package com.shshon.esstudy.product.service.dto

import com.shshon.esstudy.common.domain.Auditor
import com.shshon.esstudy.product.domain.Product
import com.shshon.esstudy.product.domain.ProductGrade

data class ProductRegisterCommand(
    val name: String,
    val price: Int,
    val stock: Int,
    val grade: ProductGrade,
    val creator: Auditor,
) {
    fun toDomain(): Product {
        return Product.create(
            name = this.name,
            price = this.price,
            stock = this.stock,
            grade = this.grade,
            creator = this.creator,
        )
    }
}
