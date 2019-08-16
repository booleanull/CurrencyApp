package com.booleanull.currencyapp.data.managers

import com.booleanull.currencyapp.data.models.CurrenciesEntity
import kotlinx.coroutines.Deferred

interface INetworkManager {

    fun getLatestCurrencies(base: String): Deferred<CurrenciesEntity>
}