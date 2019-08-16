package com.booleanull.currencyapp.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> String.fromJson(parser: Gson): T =
    parser.fromJson<T>(this, object : TypeToken<T>() {}.type)