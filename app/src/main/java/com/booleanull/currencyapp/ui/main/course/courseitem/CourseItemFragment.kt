package com.booleanull.currencyapp.ui.main.course.courseitem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.ui.base.BackButtonListener
import ru.terrakok.cicerone.commands.Back

class CourseItemFragment : Fragment(), BackButtonListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course_item, container, false)
    }

    override fun onBackPressed() {
        MyApplication.localCicerone.router.exit()
    }
}