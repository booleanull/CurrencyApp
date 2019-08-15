package com.booleanull.currencyapp.di

import com.booleanull.currencyapp.data.managers.DatabaseManager
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(databaseManager: DatabaseManager)
}