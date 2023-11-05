package com.shshon.esstudy.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration

@Configuration
class ElasticsearchConfiguration(
    @Value("\${infra.elasticsearch.host}")
    private val host: String,
    @Value("\${infra.elasticsearch.port}")
    private val port: String,
    @Value("\${infra.elasticsearch.username}")
    private val username: String,
    @Value("\${infra.elasticsearch.password}")
    private val password: String,
): ElasticsearchConfiguration() {

    override fun clientConfiguration(): ClientConfiguration {
        return ClientConfiguration.builder()
            .connectedTo("$host:$port")
            .withBasicAuth(username, password)
            .build()
    }
}
