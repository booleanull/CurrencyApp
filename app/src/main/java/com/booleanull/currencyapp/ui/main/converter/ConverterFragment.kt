package com.booleanull.currencyapp.ui.main.converter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.MyApplication
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.data.managers.IDatabaseManager
import com.booleanull.currencyapp.data.managers.INetworkManager
import com.booleanull.currencyapp.data.models.CurrenciesEntity
import com.booleanull.currencyapp.ui.MainActivity
import com.booleanull.currencyapp.ui.base.BackButtonListener
import com.booleanull.currencyapp.utils.showToast
import kotlinx.android.synthetic.main.fragment_converter.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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

    @Inject
    lateinit var databaseManager: IDatabaseManager

    @Inject
    lateinit var networkManager: INetworkManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as MainActivity).component?.inject(this)
        return inflater.inflate(R.layout.fragment_converter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button1.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                Toast.makeText(context, databaseManager.getAllCurriencies().toString(), Toast.LENGTH_SHORT).show()
            }
        }

        button2.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                val string = networkManager.getLatestCurrencies("RUB").await().toString()
                Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        cicerone.router.exit()
    }
}
