package com.prasad.moviedb.ui.binding


import android.text.Html
import android.widget.TextView
import androidx.databinding.BindingAdapter


object TextViewBinding {

    @BindingAdapter("app:textHtml")
    @JvmStatic
    fun TextView.textHtml(text: String?) {
        text?.let { setText(Html.fromHtml(it)) }
    }
}