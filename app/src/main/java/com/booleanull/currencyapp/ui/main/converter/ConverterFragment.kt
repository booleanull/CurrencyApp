package com.booleanull.currencyapp.ui.main.converter

import android.animation.*
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.animation.addListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.booleanull.currencyapp.R
import com.booleanull.currencyapp.data.managers.IDatabaseManager
import com.booleanull.currencyapp.data.managers.INetworkManager
import com.booleanull.currencyapp.domain.CurrenciesEnum
import com.booleanull.currencyapp.ui.MainActivity
import com.booleanull.currencyapp.ui.Screens
import com.booleanull.currencyapp.ui.base.BackButtonListener
import com.booleanull.currencyapp.utils.MyTextWatcher
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

    private var currencyTop = CurrenciesEnum.RUB
    private var currencyBottom = CurrenciesEnum.RUB

    private val buttonTopAnimator = AnimatorSet()
    private val buttonBottomAnimator = AnimatorSet()

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

        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.settings -> cicerone.router.navigateTo(Screens.SettingsScreen())
            }
            true
        }

        initAnimators()

        val converterAdapter = ConverterAdapter(
            listOf(
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222",
                "1111",
                "2222"
            )
        )

        recycler_view.adapter = converterAdapter
        recycler_view.layoutManager
        recycler_view.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        button_top.setOnClickListener {
            val dialog = showCurrenciesDialog(DialogInterface.OnClickListener { _, position ->
                val currenciesEnum = CurrenciesEnum.values()[position]
                currencyTop = currenciesEnum
                button_top.text = currenciesEnum.title
            })
            dialog.show()
        }

        button_bottom.setOnClickListener {
            val dialog = showCurrenciesDialog(DialogInterface.OnClickListener { _, position ->
                val currenciesEnum = CurrenciesEnum.values()[position]
                currencyBottom = currenciesEnum
                button_bottom.text = currenciesEnum.title
            })
            dialog.show()
        }

        button_change.setOnClickListener {
            val t = currencyTop
            currencyTop = currencyBottom
            currencyBottom = t

            if(!buttonTopAnimator.isRunning) {
                buttonTopAnimator.start()
            }
            if(!buttonBottomAnimator.isRunning) {
                buttonBottomAnimator.start()
            }
        }

        edit_text_top.addTextChangedListener(MyTextWatcher { text, _, _, _ ->
            if (TextUtils.isEmpty(text)) {
                text_bottom.visibility = View.GONE
                text_symbol.visibility = View.GONE
            } else {
                text_bottom.text = text
                text_bottom.visibility = View.VISIBLE
                text_symbol.visibility = View.VISIBLE
            }
        })

        /* button1.setOnClickListener {
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

    private fun initAnimators() {
        val layoutTransition = LayoutTransition()
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        constraint.layoutTransition = layoutTransition
/*
        val layoutTransitionInner = LayoutTransition()
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        layoutTransitionInner.setAnimateParentHierarchy(false)
        container_converter.layoutTransition = layoutTransitionInner*/

        val buttonTopStart = AnimatorInflater.loadAnimator(
            context,
            R.animator.button_top_start_animator
        ) as AnimatorSet
        val buttonTopEnd = AnimatorInflater.loadAnimator(
            context,
            R.animator.button_top_end_animator
        ) as AnimatorSet
        buttonTopStart.addListener(onEnd = { button_top.text = currencyTop.title })
        buttonTopAnimator.playSequentially(buttonTopStart, buttonTopEnd)
        buttonTopAnimator.setTarget(button_top)

        val buttonBottomStart = AnimatorInflater.loadAnimator(
            context,
            R.animator.button_bottom_start_animator
        ) as AnimatorSet
        val buttonBottomEnd = AnimatorInflater.loadAnimator(
            context,
            R.animator.button_bottom_end_animator
        ) as AnimatorSet
        buttonBottomStart.addListener(onEnd = { button_bottom.text = currencyBottom.title })
        buttonBottomAnimator.playSequentially(buttonBottomStart, buttonBottomEnd)
        buttonBottomAnimator.setTarget(button_bottom)
    }

    private fun showCurrenciesDialog(listener: DialogInterface.OnClickListener): AlertDialog {
        return AlertDialog.Builder(context)
            .setTitle(getString(R.string.select))
            .setItems(
                CurrenciesEnum.values().map { it.title }.toTypedArray(), listener
            )
            .setNegativeButton(getString(R.string.cancel)) { _, _ -> }
            .create()
    }

    override fun onBackPressed() {
        cicerone.router.exit()
    }
}
