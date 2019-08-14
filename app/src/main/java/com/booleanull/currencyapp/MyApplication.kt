package com.booleanull.currencyapp

import android.app.Application
import com.booleanull.currencyapp.di.AppComponent
import com.booleanull.currencyapp.di.DaggerAppComponent

class MyApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .build()
    }
}