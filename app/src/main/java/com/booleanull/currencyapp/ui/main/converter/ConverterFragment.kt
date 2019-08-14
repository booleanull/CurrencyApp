package com.booleanull.currencyapp.ui.main.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.ui.base.BackButtonListener

class ConverterFragment : Fragment(), BackButtonListener {

    companion object {
        const val TAG = "CONVERTER_FRAGMENT"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_converter, container, false)
    }

    override fun onBackPressed() {
        MyApplication.cicerone.router.exit()
    }
}
