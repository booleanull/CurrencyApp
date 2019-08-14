package com.booleanull.currencyapp.ui.main.course.courseitem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.ui.base.BackButtonListener
import com.booleanull.currencyapp.ui.main.course.CourseFragment
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.commands.Back
import javax.inject.Inject

class CourseItemFragment : Fragment(), BackButtonListener {

    @Inject
    lateinit var cicerone: Cicerone<Router>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (parentFragment as CourseFragment).component.inject(this)
        return inflater.inflate(R.layout.fragment_course_item, container, false)
    }

    override fun onBackPressed() {
        cicerone.router.exit()
    }
}