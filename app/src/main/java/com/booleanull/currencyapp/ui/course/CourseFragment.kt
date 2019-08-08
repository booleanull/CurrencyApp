package com.booleanull.currencyapp.ui.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.ui.Screens
import kotlinx.android.synthetic.main.fragment_course.view.*

class CourseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.bCourse.setOnClickListener {
            MyApplication.cicerone.router.navigateTo(Screens.CourseItemScreen())
        }
    }

    companion object {

        fun getInstanse(): CourseFragment {
            val fragment = CourseFragment()
            return fragment
        }
    }
}
