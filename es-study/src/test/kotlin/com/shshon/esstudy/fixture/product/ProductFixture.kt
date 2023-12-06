package com.shshon.esstudy.fixture.product

import com.shshon.esstudy.common.domain.Auditor
import com.shshon.esstudy.product.domain.Product
import com.shshon.esstudy.product.domain.ProductGrade
import java.util.*

object ProductFixture {

    fun sample(
        id: String = UUID.randomUUID().toString(),
        name: String = "상품",
        price: Int = 15_000,
        stock: Int = 10,
        grade: ProductGrade = ProductGrade("alphabet", "a"),
        creator: Auditor = Auditor.now("손상훈"),
        modifier: Auditor = Auditor.now("손상훈"),
    ): Product {
        return Product(
            id = id,
            name = name,
            price = price,
            stock = stock,
            grade = grade,
            creator = creator,
            modifier = modifier,
        )
    }
}
