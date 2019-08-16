package com.booleanull.currencyapp.data.network

import com.booleanull.currencyapp.data.models.CurrenciesEntity
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/latest")
    fun getLatestCurrencies(@Query("base") base: String): Deferred<CurrenciesEntity>
}