package com.booleanull.currencyapp.di

import com.booleanull.currencyapp.data.network.ApiService
import com.booleanull.currencyapp.utils.Constants.BASE_URL
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getGsonConvertFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().setLenient().create())
    }

    @Singleton
    @Provides
    fun getRxJava2Call(): CoroutineCallAdapterFactory {
        return CoroutineCallAdapterFactory()
    }

    @Singleton
    @Provides
    fun getRetrofit(gsonConverterFactory: GsonConverterFactory, coroutineCallAdapterFactory: CoroutineCallAdapterFactory): ApiService {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(coroutineCallAdapterFactory)
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiService::class.java)
    }
}