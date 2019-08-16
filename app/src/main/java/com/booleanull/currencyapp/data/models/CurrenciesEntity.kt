package com.booleanull.currencyapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.booleanull.currencyapp.data.models.base.EntityModel
import com.google.gson.annotations.Expose

@Entity
class CurrenciesEntity : EntityModel {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    @Expose
    var base: String = ""
    @Expose(serialize = false, deserialize = false)
    var rates: String = ""
    @Expose
    var date: String = ""

    override fun toString(): String {
        return base + date + rates
    }
}