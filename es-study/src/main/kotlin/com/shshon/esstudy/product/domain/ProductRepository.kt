package com.shshon.esstudy.product.domain

interface ProductRepository {

    fun save(product: Product): Product

    fun findAllByName(name: String): List<Product>
}
