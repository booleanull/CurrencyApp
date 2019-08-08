package com.booleanull.currencyapp.ui

import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.ui.converter.ConverterFragment
import com.booleanull.currencyapp.ui.course.CourseFragment
import com.booleanull.currencyapp.ui.course.courseitem.CourseItemFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    class CourseScreen: SupportAppScreen() {

        override fun getFragment(): Fragment {
            return CourseFragment.getInstanse()
        }
    }

    class CourseItemScreen: SupportAppScreen() {

        override fun getFragment(): Fragment {
            return CourseItemFragment.getInstanse()
        }
    }

    class ConverterScreen: SupportAppScreen() {
        override fun getFragment(): Fragment {
            return ConverterFragment.getInstanse()
        }

    }
}