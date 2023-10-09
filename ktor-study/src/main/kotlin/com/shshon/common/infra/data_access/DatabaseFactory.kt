package com.shshon.common.infra.data_access

import io.ktor.server.config.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object DatabaseFactory {

    fun init(config: ApplicationConfig) {
        Database.connect(
            url = config.property("ktor.database.url").getString(),
            driver = config.property("ktor.database.driver").getString(),
            user = config.property("ktor.database.username").getString(),
            password = config.property("ktor.database.password").getString(),
        )
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) {
            block()
        }
}
