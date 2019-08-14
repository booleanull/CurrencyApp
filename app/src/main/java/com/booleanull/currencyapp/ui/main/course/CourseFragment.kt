package com.booleanull.currencyapp.ui.main.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.di.course.CourseComponent
import com.booleanull.currencyapp.di.course.CourseModule
import com.booleanull.currencyapp.di.course.DaggerCourseComponent
import com.booleanull.currencyapp.ui.Screens
import com.booleanull.currencyapp.ui.base.BackButtonListener
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class CourseFragment : Fragment(), BackButtonListener {

    companion object {
        const val TAG = "COURSE_FRAGMENT"
    }

    @Inject
    lateinit var cicerone: Cicerone<Router>

    @Inject
    lateinit var navigator: Navigator

    val component: CourseComponent by lazy {
        DaggerCourseComponent.builder()
            .appComponent(MyApplication.appComponent)
            .courseModule(
                CourseModule(
                    activity!!,
                    childFragmentManager,
                    R.id.nav_host_fragment_course
                )
            )
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        component.inject(this)
        return inflater.inflate(R.layout.fragment_course, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navigator =
            SupportAppNavigator(activity, childFragmentManager, R.id.nav_host_fragment_course)

        if (childFragmentManager.findFragmentById(R.id.nav_host_fragment_course) == null) {
            cicerone.router.replaceScreen(Screens.CourseMainScreen())
        }
    }

    override fun onResume() {
        super.onResume()
        cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        cicerone.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        var fragment: Fragment? = null
        for (f in childFragmentManager.fragments) {
            if (f.isVisible) {
                fragment = f
                break
            }
        }

        if (fragment != null) {
            (fragment as BackButtonListener).onBackPressed()
        }
    }
}

