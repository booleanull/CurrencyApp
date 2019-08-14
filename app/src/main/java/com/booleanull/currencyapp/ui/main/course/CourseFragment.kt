package com.booleanull.currencyapp.ui.main.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.ui.Screens
import com.booleanull.currencyapp.ui.base.BackButtonListener
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class CourseFragment : Fragment(), BackButtonListener {

    companion object {
        const val TAG = "COURSE_FRAGMENT"
    }

    private lateinit var navigator: Navigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navigator = SupportAppNavigator(activity, childFragmentManager, R.id.nav_host_fragment_course)

        if (childFragmentManager.findFragmentById(R.id.nav_host_fragment_course) == null) {
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

    override fun onBackPressed() {
        var fragment: Fragment? = null
        for(f in childFragmentManager.fragments) {
            if(f.isVisible) {
                fragment = f
                break
            }
        }

        if(fragment != null) {
            (fragment as BackButtonListener).onBackPressed()
        } else {
            MyApplication.cicerone.router.exit()
        }
    }
}

