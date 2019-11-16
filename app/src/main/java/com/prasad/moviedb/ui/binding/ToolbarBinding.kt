package com.prasad.moviedb.ui.binding


import android.os.Build
import android.view.View
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter


object ToolbarBinding {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @BindingAdapter("app:navigationOnClickListener")
    @JvmStatic
    fun Toolbar.setNavigationOnClickListener(onClickListener: View.OnClickListener) {
        setNavigationOnClickListener(onClickListener)
    }
}