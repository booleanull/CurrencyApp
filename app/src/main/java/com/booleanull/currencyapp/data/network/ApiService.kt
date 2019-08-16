package com.booleanull.currencyapp.data.network

import com.google.gson.JsonElement
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/latest")
    fun getLatestCurrencies(@Query("base") base: String): Deferred<JsonElement>
}