package com.booleanull.currencyapp.ui

import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.ui.converter.ConverterFragment
import com.booleanull.currencyapp.ui.course.CourseFragment
import com.booleanull.currencyapp.ui.course.courseitem.CourseItemFragment
import com.booleanull.currencyapp.ui.course.coursemenu.CourseMainFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screens {

    class CourseScreen: SupportAppScreen() {

        override fun getFragment(): Fragment {
            return CourseFragment()
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

    class ConverterScreen: SupportAppScreen() {

        override fun getFragment(): Fragment {
            return ConverterFragment()
        }
    }
}