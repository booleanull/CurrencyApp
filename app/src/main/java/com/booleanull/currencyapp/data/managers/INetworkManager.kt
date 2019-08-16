package com.booleanull.currencyapp.data.managers

import com.google.gson.JsonElement
import kotlinx.coroutines.Deferred

interface INetworkManager {

    fun getLatestCurrencies(base: String): Deferred<JsonElement>
}