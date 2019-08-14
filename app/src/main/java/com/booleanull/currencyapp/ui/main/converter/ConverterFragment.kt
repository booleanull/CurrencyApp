package com.booleanull.currencyapp.ui.main.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.ui.MainActivity
import com.booleanull.currencyapp.ui.base.BackButtonListener
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ConverterFragment : Fragment(), BackButtonListener {

    companion object {
        const val TAG = "CONVERTER_FRAGMENT"
    }

    @Inject
    lateinit var cicerone: Cicerone<Router>

    @Inject
    lateinit var navigator: Navigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).component?.inject(this)
        return inflater.inflate(R.layout.fragment_converter, container, false)
    }

    override fun onBackPressed() {
        cicerone.router.exit()
    }
}
