package com.example

import com.beust.klaxon.Klaxon
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

val appId = "7a3c71b43e0b4623b82b1fb76350a665"

fun getUSDtoEUR(): Double {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://openexchangerates.org/api/latest.json?app_id=$appId")
        .build()
    var resp: String
    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) throw IOException("Unexpected code $response")
        resp = response.body!!.string()
    }
    if (resp.isEmpty()) {
        throw IOException("Response is empty")
    }
    val result = Klaxon()
        .parse<ApiRequestResponse>(resp)
    return result!!.rates.eur
}