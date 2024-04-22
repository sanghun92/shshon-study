val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val koin_version: String by project
val exposed_version: String by project

plugins {
    kotlin("jvm") version "2.3.10"
    id("io.ktor.plugin") version "3.4.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.3.10"
}

group = "com.shshon"
version = "0.0.1"

fun ktor(module: String) = "io.ktor:ktor-${module}:$ktor_version"
fun koin(module: String) = "io.insert-koin:koin-${module}:$koin_version"
fun exposed(module: String) = "org.jetbrains.exposed:exposed-${module}:$exposed_version"

application {
    mainClass.set("com.shshon.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(ktor("server-core-jvm"))
    implementation(ktor("server-content-negotiation-jvm"))
    implementation(ktor("serialization-kotlinx-json-jvm"))
    implementation(ktor("server-netty-jvm"))
    implementation(ktor("server-config-yaml"))
    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation (koin("ktor"))
    implementation (koin("logger-slf4j"))
    testImplementation (koin("test"))

    implementation("mysql:mysql-connector-java:8.0.33")
    implementation(exposed("core"))
    implementation(exposed("dao"))
    implementation(exposed("jdbc"))
    implementation(exposed("java-time"))

    testImplementation(ktor("server-test-host-jvm"))
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
