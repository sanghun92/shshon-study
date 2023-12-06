package com.shshon.esstudy.ext

import org.junit.jupiter.api.extension.ExtendWith
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@ExtendWith(
    TestContainersSupportExtension::class,
    MysqlContainerExtension::class,
    ElasticsearchContainerExtension::class,
)
annotation class TestContainersExtension()
