package com.booleanull.currencyapp.di.main

import com.booleanull.currencyapp.di.AppComponent
import com.booleanull.currencyapp.ui.MainActivity
import com.booleanull.currencyapp.ui.main.MainFragment
import com.booleanull.currencyapp.ui.main.converter.ConverterFragment
import com.booleanull.currencyapp.ui.settings.SettingsFragment
import dagger.Component

@MainScope
@Component(dependencies = [AppComponent::class], modules = [MainModule::class])
interface MainComponent : AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(mainFragment: MainFragment)

    fun inject(converterFragment: ConverterFragment)

    fun inject(settingsFragment: SettingsFragment)
}