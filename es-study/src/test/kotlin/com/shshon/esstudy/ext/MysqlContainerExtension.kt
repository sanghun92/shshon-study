package com.shshon.esstudy.ext

import com.shshon.esstudy.ext.TestContainersSupportExtension.Companion.network
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.Extension
import org.junit.jupiter.api.extension.ExtensionContext
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.utility.DockerImageName

class MysqlContainerExtension: Extension, BeforeAllCallback {
    companion object {
        internal const val MYSQL_AS = "mysql"
        private val mysqlContainer = MySQLContainer(DockerImageName.parse("mysql:8.0.35-debian").asCompatibleSubstituteFor("mysql"))
            .withDatabaseName("test")
            .withUsername("testname")
            .withPassword("testpwd")
            .withNetwork(network)
            .withNetworkAliases(MYSQL_AS)
    }

    override fun beforeAll(context: ExtensionContext?) {
        if(mysqlContainer.isRunning) {
            return
        }
        mysqlContainer.start()
    }
}
