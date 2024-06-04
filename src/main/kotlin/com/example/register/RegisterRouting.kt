package com.example.register

import com.example.cache.InMemoryCache
import com.example.cache.TokenCache
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

fun Application.configureRegisterRouting(){
    routing {
        post("/register"){
            val receive = call.receive<RegisterReceiveRemote>()
            if(false){
                call.respond(HttpStatusCode.BadRequest, "Email is not valid")
            }
            if(InMemoryCache.useList.map { it.login }.contains(receive.login)){
                call.respond(HttpStatusCode.Conflict, "User, already exists")
            }
            val token = UUID.randomUUID().toString()
            InMemoryCache.useList.add(receive)
            InMemoryCache.token.add(TokenCache(login = receive.login, token = token))
            call.respond(RegisterResponseRemote(token = token))
        }
    }
}