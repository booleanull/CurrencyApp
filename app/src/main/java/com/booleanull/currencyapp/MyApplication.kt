package com.booleanull.currencyapp

import android.app.Application
import com.booleanull.currencyapp.di.AppComponent
import com.booleanull.currencyapp.di.DaggerAppComponent
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class MyApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
            private set

        lateinit var cicerone: Cicerone<Router>
            private set

        lateinit var localCicerone: Cicerone<Router>
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .build()

        cicerone = Cicerone.create()
        localCicerone = Cicerone.create()
    }
}