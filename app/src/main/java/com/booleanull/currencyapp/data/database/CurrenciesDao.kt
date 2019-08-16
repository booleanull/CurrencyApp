package com.booleanull.currencyapp.data.database

import androidx.room.*
import com.booleanull.currencyapp.data.models.CurrenciesEntity

@Dao
interface CurrenciesDao {

    @Query("SELECT * FROM currenciesentity ORDER BY baseAndDate")
    suspend fun all(): List<CurrenciesEntity>

    @Query("SELECT * FROM currenciesentity WHERE baseAndDate = :baseAndDate")
    suspend fun getCurrenciesByBaseAndDate(baseAndDate:String): CurrenciesEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(models: List<CurrenciesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(model: CurrenciesEntity)

    @Delete
    suspend fun delete(model: CurrenciesEntity)

    @Query("DELETE FROM currenciesentity")
    suspend fun deleteAll()
}