package com.shshon.esstudy.config

import com.shshon.esstudy.ext.ElasticsearchContainerExtension
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@TestConfiguration
@EnableElasticsearchRepositories(basePackages = ["com.shshon.esstudy"])
class ElasticsearchTestConfiguration: ElasticsearchConfiguration() {

    override fun clientConfiguration(): ClientConfiguration {
        return ClientConfiguration.builder()
            .connectedTo(ElasticsearchContainerExtension.getHost())
            .withBasicAuth(ES_USERNAME, ES_PASSWORD)
            .build()
    }

    companion object {
        internal const val ES_USERNAME = "elastic"
        internal const val ES_PASSWORD = "changeme"
    }
}
