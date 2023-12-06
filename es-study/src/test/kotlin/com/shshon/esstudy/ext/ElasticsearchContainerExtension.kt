package com.shshon.esstudy.ext

import com.shshon.esstudy.ext.TestContainersSupportExtension.Companion.network
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.Extension
import org.junit.jupiter.api.extension.ExtensionContext
import org.testcontainers.elasticsearch.ElasticsearchContainer
import org.testcontainers.utility.DockerImageName

class ElasticsearchContainerExtension: Extension, BeforeAllCallback {
    companion object {
        private const val ELASTIC_SEARCH_IMAGE = "docker.elastic.co/elasticsearch/elasticsearch:7.16.3"
        internal const val ELASTIC_SEARCH_AS = "elasticsearch"
        private val elasticsearchContainer = ElasticsearchContainer(DockerImageName.parse(ELASTIC_SEARCH_IMAGE))
            .withPassword("changeme")
            .withNetwork(network)
            .withNetworkAliases(ELASTIC_SEARCH_AS)

        fun getHost(): String {
            return elasticsearchContainer.httpHostAddress
        }
    }

    override fun beforeAll(context: ExtensionContext?) {
        if(elasticsearchContainer.isRunning) {
            return
        }
        elasticsearchContainer.start()
    }
}
