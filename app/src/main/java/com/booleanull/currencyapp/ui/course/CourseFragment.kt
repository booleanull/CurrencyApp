package com.booleanull.currencyapp.ui.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.ui.Screens
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class CourseFragment : Fragment() {

    companion object {
        val TAG = "COURSE_FRAGMENT"
    }

    lateinit var navigator: Navigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navigator = SupportAppNavigator(activity, childFragmentManager, R.id.course_nav_host)

        if (childFragmentManager.findFragmentById(R.id.course_nav_host) == null) {
            MyApplication.localCicerone.router.replaceScreen(Screens.CourseMainScreen())
        }
    }

    override fun onResume() {
        super.onResume()
        MyApplication.localCicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        MyApplication.localCicerone.navigatorHolder.removeNavigator()
    }
}

