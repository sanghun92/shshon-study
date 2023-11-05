package com.shshon.esstudy.product.service

import com.shshon.esstudy.product.domain.Product
import com.shshon.esstudy.product.domain.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductQueryService(
    private val productRepository: ProductRepository,
) {

    fun findAllByName(name: String): List<Product> {
        return this.productRepository.findAllByName(name = name)
    }
}
