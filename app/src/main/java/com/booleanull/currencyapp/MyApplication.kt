package com.booleanull.currencyapp

import android.app.Application
import com.booleanull.currencyapp.di.*

class MyApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .databaseModule(DatabaseModule())
            .networkModule(NetworkModule())
            .build()
    }
}