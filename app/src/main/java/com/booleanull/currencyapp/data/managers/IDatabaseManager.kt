package com.booleanull.currencyapp.data.managers

import com.booleanull.currencyapp.data.models.CurrenciesEntity

interface IDatabaseManager {

    suspend fun getAllCurriencies(): List<CurrenciesEntity>

    suspend fun getCurrenciesByDate(date: String): List<CurrenciesEntity>

    suspend fun getCurrenciesByBaseAndDate(base:String, date: String): CurrenciesEntity

    suspend fun insertCurrencies(currenciesEntity: CurrenciesEntity)

    suspend fun insertAllCurrencies(list: List<CurrenciesEntity>)

    suspend fun deleteCurriencies(currenciesEntity: CurrenciesEntity)

    suspend fun deleteAllCurriencies()
}
