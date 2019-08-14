package com.booleanull.currencyapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.ui.MainActivity
import com.booleanull.currencyapp.ui.Screens
import com.booleanull.currencyapp.ui.base.BackButtonListener
import com.booleanull.currencyapp.ui.main.converter.ConverterFragment
import com.booleanull.currencyapp.ui.main.course.CourseFragment
import kotlinx.android.synthetic.main.fragment_main.*
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainFragment : Fragment(), BackButtonListener {

    @Inject
    lateinit var cicerone: Cicerone<Router>

    @Inject
    lateinit var navigator: Navigator

    private var selectedFragment: Fragment? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).component?.inject(this)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.settings -> cicerone.router.navigateTo(Screens.SettingsScreen())
            }
            true
        }

        navigation.setOnNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.navigation_course -> selectNavigationItem(CourseFragment.TAG, CourseFragment())
                R.id.navigation_converter -> selectNavigationItem(
                    ConverterFragment.TAG,
                    ConverterFragment()
                )
            }

            return@setOnNavigationItemSelectedListener true
        }

        if(savedInstanceState == null && childFragmentManager.fragments.size == 0) {
            navigation.selectedItemId = R.id.navigation_course
        }
    }

    private fun selectNavigationItem(tab: String, fragment: Fragment) {
        var currentFragment: Fragment? = null
        val fragments = childFragmentManager.fragments
        for (f in fragments) {
            if (f.isVisible) {
                currentFragment = f
                break
            }
        }

        selectedFragment = childFragmentManager.findFragmentByTag(tab)

        if (currentFragment != null && selectedFragment != null && currentFragment === selectedFragment) return

        val transaction = childFragmentManager.beginTransaction()
        if (selectedFragment == null) {
            transaction.add(R.id.nav_host_fragment_main, fragment, tab)
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
            cicerone.router.exit()
        }
    }
}