package com.booleanull.currencyapp.ui.main.course.coursemenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.ui.Screens
import com.booleanull.currencyapp.ui.base.BackButtonListener
import com.booleanull.currencyapp.ui.main.course.CourseFragment
import kotlinx.android.synthetic.main.fragment_course_main.*
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class CourseMainFragment : Fragment(), BackButtonListener {

    @Inject
    lateinit var cicerone: Cicerone<Router>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (parentFragment as CourseFragment).component.inject(this)
        return inflater.inflate(R.layout.fragment_course_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button.setOnClickListener {
            cicerone.router.navigateTo(Screens.CourseItemScreen())
        }
    }

    override fun onBackPressed() {
        cicerone.router.exit()
    }
}