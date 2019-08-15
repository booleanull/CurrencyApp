package com.booleanull.currencyapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.booleanull.currencyapp.data.models.CurrenciesEntity

@Database(entities = [CurrenciesEntity::class], version = 1, exportSchema = false)
abstract class CurrenciesDatabase : RoomDatabase() {

    abstract fun provideCurrenciesDao(): CurrenciesDao
}