package com.shshon.esstudy.product.infra

import com.shshon.esstudy.common.domain.Auditor
import com.shshon.esstudy.product.domain.Product
import com.shshon.esstudy.product.infra.elastic_search.ProductDocument
import java.time.ZoneId
import java.time.ZoneOffset

internal fun ProductDocument.toDomain(): Product {
    return Product(
        id = this.id,
        name = this.name,
        price = this.price,
        stock = this.stock,
        grade = this.grade,
        creator = Auditor(
            auditedBy = this.createdBy,
            auditedAt = this.createdAt.withZoneSameInstant(ZoneId.of("Asia/Seoul")).toLocalDateTime(),
        ),
        modifier = Auditor(
            auditedBy = this.modifiedBy,
            auditedAt = this.modifiedAt.withZoneSameInstant(ZoneId.of("Asia/Seoul")).toLocalDateTime(),
        )
    )
}

internal fun Product.toDocument(): ProductDocument {
    return ProductDocument(
        id = this.id,
        name = this.name,
        price = this.price,
        stock = this.stock,
        grade = this.grade,
        createdBy = this.creator.auditedBy,
        createdAt = this.creator.auditedAt.atZone(ZoneId.of("UTC")),
        modifiedBy = this.modifier.auditedBy,
        modifiedAt = this.modifier.auditedAt.atZone(ZoneId.of("UTC")),
    )
}
