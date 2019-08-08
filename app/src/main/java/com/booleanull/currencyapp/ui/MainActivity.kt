package com.booleanull.currencyapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

class MainActivity : AppCompatActivity() {

    private val navigator = object : SupportAppNavigator(this, R.id.nav_host_fragment) {

        override fun applyCommand(command: Command?) {
            super.applyCommand(command)
            supportFragmentManager.executePendingTransactions()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.navigation_course -> MyApplication.cicerone.router.replaceScreen(Screens.CourseScreen())
                R.id.navigation_converter -> MyApplication.cicerone.router.replaceScreen(Screens.ConverterScreen())
            }

            return@setOnNavigationItemSelectedListener true
        }

        if (savedInstanceState == null)
            MyApplication.cicerone.router.replaceScreen(Screens.CourseScreen())
    }

    override fun onResume() {
        super.onResume()
        MyApplication.cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        MyApplication.cicerone.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        MyApplication.cicerone.router.exit()
    }
}
