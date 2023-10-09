package com.shshon.plugins

import com.shshon.common.infra.data_access.DatabaseFactory
import io.ktor.server.application.*

fun Application.configureDatabase() {
    DatabaseFactory.init(config = App)
}
