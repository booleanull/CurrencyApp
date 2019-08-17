package com.booleanull.currencyapp.utils

import android.text.Editable
import android.text.TextWatcher

class MyTextWatcher (val onTextChanged: (text: CharSequence?, start: Int, before: Int, count: Int) -> Unit): TextWatcher {

    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        onTextChanged.invoke(p0, p1, p2, p3)
    }
}