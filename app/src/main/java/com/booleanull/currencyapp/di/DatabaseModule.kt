package com.booleanull.currencyapp.di

import android.content.Context
import androidx.room.Room
import com.booleanull.currencyapp.data.database.CurrenciesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    internal fun provideDatabase(context: Context): CurrenciesDatabase {
        return Room.databaseBuilder(context, CurrenciesDatabase::class.java, "currencies").build()
    }
}
