package com.example

import com.example.login.configureLoginRouting
import com.example.plugins.*
import com.example.register.configureRegisterRouting
import io.ktor.server.application.*
import io.ktor.server.cio.*
import com.datastax.oss.driver.api.core.CqlSession
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.engine.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import java.net.InetSocketAddress

public fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
    val session = CqlSession.builder()
}

public fun Application.module() {
    configureSerialization()
    configureRouting()
    configureLoginRouting()
    configureRegisterRouting()
}
@Serializable
data class Login(val username: String, val password: String)
