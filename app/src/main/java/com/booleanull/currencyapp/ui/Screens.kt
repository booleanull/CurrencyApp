package com.booleanull.currencyapp.ui

import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.ui.main.MainFragment
import com.booleanull.currencyapp.ui.main.converter.ConverterFragment
import com.booleanull.currencyapp.ui.main.course.CourseFragment
import com.booleanull.currencyapp.ui.main.course.courseitem.CourseItemFragment
import com.booleanull.currencyapp.ui.main.course.coursemenu.CourseMainFragment
import com.booleanull.currencyapp.ui.settings.SettingsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screens {

    class MainScreen: SupportAppScreen() {

        override fun getFragment(): Fragment {
            return MainFragment()
        }
    }

    class CourseMainScreen: SupportAppScreen() {

        override fun getFragment(): Fragment {
            return CourseMainFragment()
        }
    }

    class CourseItemScreen: SupportAppScreen() {

        override fun getFragment(): Fragment {
            return CourseItemFragment()
        }
    }

    class SettingsScreen: SupportAppScreen() {

        override fun getFragment(): Fragment {
            return SettingsFragment()
        }
    }
}