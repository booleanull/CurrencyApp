package com.booleanull.currencyapp.di

import android.content.Context
import com.booleanull.currencyapp.data.database.CurrenciesDatabase
import com.booleanull.currencyapp.data.managers.DatabaseManager
import com.booleanull.currencyapp.data.managers.IDatabaseManager
import com.booleanull.currencyapp.data.managers.INetworkManager
import com.booleanull.currencyapp.data.network.ApiService
import com.booleanull.currencyapp.ui.MainActivity
import com.google.gson.Gson
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DatabaseModule::class, NetworkModule::class])
interface AppComponent {

    fun context(): Context

    fun currenciesDatabase(): CurrenciesDatabase

    fun databaseManager(): IDatabaseManager

    fun apiService(): ApiService

    fun gson(): Gson

    fun networkManager(): INetworkManager
}