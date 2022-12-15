package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

val USD = "numberOfUSD"

fun Application.configureRouting() {

    routing {
        get("/convert") {
            val degree = call.parameters[USD]
            call.respondText("Hello World!")
        }
    }
}
