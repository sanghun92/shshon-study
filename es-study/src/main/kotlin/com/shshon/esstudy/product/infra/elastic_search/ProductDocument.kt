package com.shshon.esstudy.product.infra.elastic_search

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "products")
data class ProductDocument(
    @Id
    val id: String,

    @Field(type = FieldType.Text)
    val name: String,

    @Field(type = FieldType.Integer)
    val price: Int,

    @Field(type = FieldType.Integer)
    val stock: Int = 0,
)
