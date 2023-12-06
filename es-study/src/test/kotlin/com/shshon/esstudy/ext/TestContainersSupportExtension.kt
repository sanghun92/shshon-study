package com.shshon.esstudy.ext

import org.junit.jupiter.api.extension.Extension
import org.testcontainers.containers.Network

class TestContainersSupportExtension: Extension {
    companion object {
        val network = Network.newNetwork()
    }
}
