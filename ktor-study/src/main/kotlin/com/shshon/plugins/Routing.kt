package com.shshon.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.getKoin

fun Application.configureRouting() {
    val apis = getKoin().getAll<Api>().toSet()
    val log = log

    routing {
        log.info("Registered api.")
        if(log.isDebugEnabled) {
            apis.forEach { api  ->
                log.info("Api : ${api.javaClass.simpleName}")
                api(this@configureRouting)
            }
        }
    }
}

abstract class Api(val route: Routing.() -> Unit) {
    operator fun invoke(app: Application) = app.routing {
        route()
    }
}
