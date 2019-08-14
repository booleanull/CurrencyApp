package com.booleanull.currencyapp.di.main

import com.booleanull.currencyapp.ui.MainActivity
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Singleton

@Module
class MainModule(private val activity: MainActivity, private val container: Int) {

    @MainScope
    @Provides
    internal fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @MainScope
    @Provides
    internal fun provideNavigation(): Navigator =
        SupportAppNavigator(activity, container)
}