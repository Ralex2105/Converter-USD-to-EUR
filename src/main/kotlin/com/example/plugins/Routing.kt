package com.example.plugins

import com.example.getUSDtoEUR
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

const val VALUE = "value"
fun Application.configureRouting() {

    routing {
        get("/convert/USDtoEUR") {
            try {
                val value = call.parameters[VALUE]
                if (value == null) {
                    call.respondText("ERROR: No input value")
                } else {
                    call.respondText((value.toDouble() * getUSDtoEUR()).toString())
                }
            } catch (e: NumberFormatException) {
                call.respondText("ERROR: input value is not a number")
            } catch (e: NullPointerException) {
                call.respondText("ERROR: Can not get the exchange rate")
            }
        }
        get("/convert/EURtoUSD") {
            try {
                val value = call.parameters[VALUE]
                if (value == null) {
                    call.respondText("ERROR: No input value")
                } else {
                    call.respondText((value.toDouble() / getUSDtoEUR()).toString())
                }
            } catch (e: NumberFormatException) {
                call.respondText("ERROR: input value is not a number")
            } catch (e: NullPointerException) {
                call.respondText("ERROR: Can not get the exchange rate")
            }
        }
    }
}
