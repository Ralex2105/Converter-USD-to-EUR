package com.example

import com.beust.klaxon.Json

data class Rates(
    @Json(name = "EUR")
    val eur: Double
)

data class ApiRequestResponse(
    @Json(name = "rates")
    val rates: Rates
)