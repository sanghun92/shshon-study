package com.shshon.esstudy.product.infra

import com.shshon.esstudy.product.domain.Product
import com.shshon.esstudy.product.infra.elastic_search.ProductDocument

fun ProductDocument.toDomain(): Product {
    return Product(
        id = this.id,
        name = this.name,
        price = this.price,
        stock = this.stock,
    )
}

fun Product.toDocument(): ProductDocument {
    return ProductDocument(
        id = this.id,
        name = this.name,
        price = this.price,
        stock = this.stock,
    )
}
