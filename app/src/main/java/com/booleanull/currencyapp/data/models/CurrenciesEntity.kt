package com.booleanull.currencyapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.booleanull.currencyapp.data.models.base.EntityModel

@Entity
class CurrenciesEntity : EntityModel {

    @PrimaryKey
    var baseAndDate: String = ""
    var rates: String = ""

    override fun toString(): String {
        return baseAndDate + rates
    }
}