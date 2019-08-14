package com.booleanull.currencyapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.ui.converter.ConverterFragment
import com.booleanull.currencyapp.ui.course.CourseFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var selectedFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.navigation_course -> selectNavigationItem(CourseFragment.TAG, CourseFragment())
                R.id.navigation_converter -> selectNavigationItem(ConverterFragment.TAG, ConverterFragment())
            }

            return@setOnNavigationItemSelectedListener true
        }
        navigation.selectedItemId = R.id.navigation_course
    }

    private fun selectNavigationItem(tab: String, fragment: Fragment) {
        val fm = supportFragmentManager
        var currentFragment: Fragment? = null
        val fragments = fm.fragments
        if (fragments != null) {
            for (f in fragments) {
                if (f.isVisible) {
                    currentFragment = f
                    break
                }
            }
        }
        selectedFragment = fm.findFragmentByTag(tab)

        if (currentFragment != null && selectedFragment != null && currentFragment === selectedFragment) return

        val transaction = fm.beginTransaction()
        if (selectedFragment == null) {
            transaction.add(R.id.nav_host_fragment, fragment, tab)
            selectedFragment = fragment
        }

        if (currentFragment != null) {
            transaction.hide(currentFragment)
        }

        if (selectedFragment != null) {
            transaction.show(selectedFragment!!)
        }
        transaction.commitNow()
    }

    override fun onBackPressed() {
        if(selectedFragment?.tag == CourseFragment.TAG) {
            MyApplication.localCicerone.router.exit()
        } else {
            super.onBackPressed()
        }
    }
}
