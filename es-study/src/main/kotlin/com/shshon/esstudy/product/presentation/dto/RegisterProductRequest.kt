package com.shshon.esstudy.product.presentation.dto

import com.shshon.esstudy.common.domain.Auditor
import com.shshon.esstudy.product.domain.ProductGrade
import com.shshon.esstudy.product.service.dto.ProductRegisterCommand

data class RegisterProductRequest(
    val name: String,
    val price: Int,
    val stock: Int,
    val gradeType: String,
    val grade: String,
    val registerBy: String,
) {
    fun toCommand(): ProductRegisterCommand {
        return ProductRegisterCommand(
            name = this.name,
            price = this.price,
            stock = this.stock,
            grade = ProductGrade(gradeType, grade),
            creator = Auditor.now(auditedBy = this.registerBy)
        )
    }
}
