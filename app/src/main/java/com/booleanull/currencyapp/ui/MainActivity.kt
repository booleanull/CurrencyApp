package com.booleanull.currencyapp.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.di.main.DaggerMainComponent
import com.booleanull.currencyapp.di.main.MainComponent
import com.booleanull.currencyapp.di.main.MainModule
import com.booleanull.currencyapp.ui.base.BackButtonListener
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var cicerone: Cicerone<Router>

    @Inject
    lateinit var navigator: Navigator

    val component: MainComponent? by lazy {
        DaggerMainComponent.builder()
            .appComponent(MyApplication.appComponent)
            .mainModule(MainModule(this, R.id.nav_host_fragment))
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component?.inject(this)

        if(savedInstanceState == null) {
            cicerone.router.replaceScreen(Screens.MainScreen())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> cicerone.router.navigateTo(Screens.SettingsScreen())
        }
        return super.onOptionsItemSelected(item)
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
