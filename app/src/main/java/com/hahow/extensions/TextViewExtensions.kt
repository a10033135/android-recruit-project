package com.hahow.extensions

import android.widget.TextView

fun TextView.setTextIf(text: String?) {
    if (text.isNullOrEmpty()) {
        visibility = TextView.GONE
    } else {
        visibility = TextView.VISIBLE
        setText(text)
    }
}