package com.booleanull.currencyapp.di.course

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

@Module
class CourseModule(
    private val fragmentActivity: FragmentActivity,
    private val fm: FragmentManager,
    private val container: Int
) {

    @CourseScope
    @Provides
    internal fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @CourseScope
    @Provides
    internal fun provideNavigation(): Navigator =
        SupportAppNavigator(fragmentActivity, fm, container)
}