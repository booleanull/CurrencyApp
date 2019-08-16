package com.booleanull.currencyapp.data.managers

import com.booleanull.currencyapp.data.models.CurrenciesEntity
import com.google.gson.JsonElement
import kotlinx.coroutines.Deferred

interface INetworkManager {

    fun getLatestCurrencies(base: String): Deferred<JsonElement>
}