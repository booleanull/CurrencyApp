package com.booleanull.currencyapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.ui.base.BackButtonListener
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment(), BackButtonListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager
            .beginTransaction()
            .replace(R.id.settings, SettingsPrefFragment())
            .commitNow()

        toolbar.navigationIcon = ContextCompat.getDrawable(context!!, R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        MyApplication.cicerone.router.exit()
    }

    class SettingsPrefFragment : PreferenceFragmentCompat() {

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }
}