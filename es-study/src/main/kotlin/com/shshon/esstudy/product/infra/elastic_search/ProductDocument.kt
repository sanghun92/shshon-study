package com.shshon.esstudy.product.infra.elastic_search

import com.shshon.esstudy.product.domain.ProductGrade
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.DateFormat
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.time.LocalDateTime
import java.time.ZonedDateTime

@Document(indexName = "products", createIndex = false)
data class ProductDocument(
    @Id
    val id: String,

    @Field(type = FieldType.Text)
    val name: String,

    @Field(type = FieldType.Integer)
    val price: Int,

    @Field(type = FieldType.Integer)
    val stock: Int = 0,

    @Field(type = FieldType.Nested)
    val grade: ProductGrade,

    @Field(type = FieldType.Text)
    val createdBy: String,

    @Field(type = FieldType.Date, format = [DateFormat.date_time, DateFormat.epoch_millis])
    val createdAt: ZonedDateTime,

    @Field(type = FieldType.Text)
    val modifiedBy: String,

    @Field(type = FieldType.Date, format = [DateFormat.date_time, DateFormat.epoch_millis])
    val modifiedAt: ZonedDateTime,
)
