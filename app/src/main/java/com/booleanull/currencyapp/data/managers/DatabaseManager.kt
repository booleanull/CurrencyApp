package com.booleanull.currencyapp.data.managers

import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.data.database.CurrenciesDatabase
import com.booleanull.currencyapp.data.models.CurrenciesEntity
import javax.inject.Inject

class DatabaseManager : IDatabaseManager {

    @Inject
    lateinit var currenciesDatabase: CurrenciesDatabase

    init {
        MyApplication.appComponent.inject(this)
    }

    override suspend fun getAllCurriencies(): List<CurrenciesEntity> {
        return currenciesDatabase.provideCurrenciesDao().all()
    }

    override suspend fun getCurrenciesByDate(date: String): List<CurrenciesEntity> {
        return currenciesDatabase.provideCurrenciesDao().getCurrenciesByDate(date)
    }

    override suspend fun getCurrenciesByBaseAndDate(base: String, date: String): CurrenciesEntity {
        return currenciesDatabase.provideCurrenciesDao().getCurrenciesByBaseAndDate(base, date)
    }

    override suspend fun insertCurrencies(currenciesEntity: CurrenciesEntity) {
        currenciesDatabase.provideCurrenciesDao().insert(currenciesEntity)
    }

    override suspend fun insertAllCurrencies(list: List<CurrenciesEntity>) {
        currenciesDatabase.provideCurrenciesDao().insert(list)
    }

    override suspend fun deleteCurriencies(currenciesEntity: CurrenciesEntity) {
        currenciesDatabase.provideCurrenciesDao().delete(currenciesEntity)
    }

    override suspend fun deleteAllCurriencies() {
        currenciesDatabase.provideCurrenciesDao().deleteAll()
    }
}