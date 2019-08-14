package com.booleanull.currencyapp.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.ui.base.BackButtonListener
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : AppCompatActivity() {

    private val navigator = SupportAppNavigator(this, R.id.nav_host_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            MyApplication.cicerone.router.replaceScreen(Screens.MainScreen())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> MyApplication.cicerone.router.navigateTo(Screens.SettingsScreen())
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        MyApplication.cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        MyApplication.cicerone.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        var fragment: Fragment? = null
        for(f in supportFragmentManager.fragments) {
            if(f.isVisible) {
                fragment = f
                break
            }
        }

        if(fragment != null) {
            (fragment as BackButtonListener).onBackPressed()
        } else {
            super.onBackPressed()
        }
    }
}
