package com.booleanull.currencyapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.booleanull.currencyapp.data.models.base.EntityModel
import com.google.gson.annotations.Expose

@Entity
class CurrenciesEntity : EntityModel {

    @PrimaryKey
    var id: Int = 0
    @Expose
    var base: String = ""
    @Expose
    var rates: Map<String, Double> = mapOf()
    @Expose
    var date: String = ""
}