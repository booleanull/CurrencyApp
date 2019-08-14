package com.booleanull.currencyapp.di.course

import com.booleanull.currencyapp.di.AppComponent
import com.booleanull.currencyapp.ui.main.course.CourseFragment
import com.booleanull.currencyapp.ui.main.course.courseitem.CourseItemFragment
import com.booleanull.currencyapp.ui.main.course.coursemenu.CourseMainFragment
import dagger.Component

@CourseScope
@Component(dependencies = [AppComponent::class], modules = [CourseModule::class])
interface CourseComponent: AppComponent {

    fun inject(courseFragment: CourseFragment)

    fun inject(courseMainFragment: CourseMainFragment)

    fun inject(courseItemFragment: CourseItemFragment)
}