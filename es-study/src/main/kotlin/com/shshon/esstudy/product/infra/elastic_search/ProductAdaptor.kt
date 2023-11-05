package com.shshon.esstudy.product.infra.elastic_search

import com.shshon.esstudy.product.domain.Product
import com.shshon.esstudy.product.domain.ProductRepository
import org.springframework.stereotype.Repository

@Repository
class ProductAdaptor(
    private val productElasticsearchRepository: ProductElasticsearchRepository,
): ProductRepository {

    override fun save(product: Product): Product {
        this.productElasticsearchRepository.save(product.toDocument())
        return product
    }

    override fun findAllByName(name: String): List<Product> {
        return productElasticsearchRepository.findAllByName(name = name)
            .map { it.toDomain() }
    }
}
