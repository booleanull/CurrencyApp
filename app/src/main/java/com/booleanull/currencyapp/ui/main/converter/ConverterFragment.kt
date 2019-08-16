package com.booleanull.currencyapp.ui.main.converter

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.data.managers.IDatabaseManager
import com.booleanull.currencyapp.data.managers.INetworkManager
import com.booleanull.currencyapp.data.models.CurrenciesEntity
import com.booleanull.currencyapp.domain.CurrenciesEnum
import com.booleanull.currencyapp.ui.MainActivity
import com.booleanull.currencyapp.ui.base.BackButtonListener
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_converter.*
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
    lateinit var gson: Gson

    @Inject
    lateinit var databaseManager: IDatabaseManager

    @Inject
    lateinit var networkManager: INetworkManager

    var currencyFirst = CurrenciesEnum.RUB
    var currencySecond = CurrenciesEnum.RUB

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

        button_top.setOnClickListener {
            val dialog = showCurrenciesDialog(DialogInterface.OnClickListener { p0, position ->
                val currenciesEnum = CurrenciesEnum.values()[position]
                currencySecond = currenciesEnum
                button_top.text = currenciesEnum.title
            })
            dialog.show()
        }

        button_bottom.setOnClickListener {
            val dialog = showCurrenciesDialog(DialogInterface.OnClickListener { p0, position ->
                val currenciesEnum = CurrenciesEnum.values()[position]
                currencyFirst = currenciesEnum
                button_bottom.text = currenciesEnum.title
            })
            dialog.show()
        }

        button_change.setOnClickListener {
            val t = currencyFirst
            currencyFirst = currencySecond
            currencySecond = t

            button_top.text = currencyFirst.title
            button_bottom.text = currencySecond.title
        }

        edit_text_top.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                edit_text_bottom.setText(text)
            }

        })

        /*button1.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                val curriencies = databaseManager.getAllCurriencies().map {
                    it.rates.fromJson<HashMap<String, Double>>(gson).keys
                }
                Toast.makeText(context, curriencies.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        button2.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                val jsonObject = networkManager.getLatestCurrencies("RUB").await().asJsonObject
                val currenciesEntity = CurrenciesEntity().apply {
                    base = jsonObject.get("base").asString
                    date = jsonObject.get("date").asString
                    rates = jsonObject.get("rates").toString()
                    generatePrimaryKey()
                }
                databaseManager.insertCurrencies(currenciesEntity)
            }
        }*/
    }

    private fun showCurrenciesDialog(listener: DialogInterface.OnClickListener): AlertDialog {
        val dialog = AlertDialog.Builder(context)
            .setTitle(getString(R.string.select))
            .setItems(
                CurrenciesEnum.values().map { it.title }.toTypedArray(), listener)
            .setNegativeButton(getString(R.string.cancel)) { dialogInterface, i -> }
            .create()
        return dialog
    }

    override fun onBackPressed() {
        cicerone.router.exit()
    }
}
