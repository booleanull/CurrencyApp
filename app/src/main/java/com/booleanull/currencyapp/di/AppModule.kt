package com.booleanull.currencyapp.di

import android.content.Context
import com.booleanull.currencyapp.data.managers.DatabaseManager
import com.booleanull.currencyapp.data.managers.IDatabaseManager
import com.booleanull.currencyapp.data.managers.INetworkManager
import com.booleanull.currencyapp.data.managers.NetworkManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    internal fun provideContext() = context

    @Singleton
    @Provides
    internal fun provideDatabaseManager(): IDatabaseManager {
        return DatabaseManager()
    }

    @Singleton
    @Provides
    internal fun provideNetworkManager(): INetworkManager {
        return NetworkManager()
    }
}