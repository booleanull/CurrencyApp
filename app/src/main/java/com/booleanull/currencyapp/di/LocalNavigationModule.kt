package com.booleanull.currencyapp.di

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class LocalNavigationModule {

    @Singleton
    @Provides
    internal fun provideCourseLocalNavigation(): Cicerone<Router> {
        return Cicerone.create()
    }
}