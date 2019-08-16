package com.booleanull.currencyapp.data.managers

import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.data.models.CurrenciesEntity
import com.booleanull.currencyapp.data.network.ApiService
import com.google.gson.JsonElement
import kotlinx.coroutines.Deferred

class NetworkManager : INetworkManager {

    val apiService: ApiService = MyApplication.appComponent.apiService()

    override fun getLatestCurrencies(base: String): Deferred<JsonElement> {
        return apiService.getLatestCurrencies(base)
    }
}