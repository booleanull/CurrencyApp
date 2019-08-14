package com.booleanull.currencyapp.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class LocalNavigationModule {

    @Provides
    @Singleton
    internal fun provideLocalNavigation(): Cicerone<Router> {
        return Cicerone.create()
    }
}