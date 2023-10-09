package com.shshon.plugins

import com.shshon.customers.customerModules
import io.ktor.server.application.*
import org.koin.core.annotation.KoinInternalApi
import org.koin.ktor.ext.getKoin
import org.koin.ktor.plugin.Koin
import org.koin.ktor.plugin.KoinApplicationStarted
import org.koin.ktor.plugin.KoinApplicationStopPreparing
import org.koin.ktor.plugin.KoinApplicationStopped
import org.koin.logger.SLF4JLogger

fun Application.configureKoinModules() {
    val log = log

    install(Koin) {
        SLF4JLogger()
        log.info("koin install started.")
        modules(koinModules)
    }
    environment.monitor.subscribe(KoinApplicationStarted) {
        if(log.isDebugEnabled) {
            getKoin().getAll<Any>()
                .forEach { log.info(it.javaClass.simpleName) }
        }
        log.info("Koin container started.")
    }
    environment.monitor.subscribe(KoinApplicationStopPreparing) {
        log.info("Koin stopping...")
    }
    environment.monitor.subscribe(KoinApplicationStopped) {
        log.info("Koin stopped.")
    }
}

private val koinModules = listOf(
    customerModules
).flatten()
.flatten()
