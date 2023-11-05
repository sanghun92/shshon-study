package com.shshon.esstudy.product.infra.elastic_search

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface ProductElasticsearchRepository: ElasticsearchRepository<ProductDocument, String> {

    fun findAllByName(name: String): List<ProductDocument>
}
