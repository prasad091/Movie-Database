package com.prasad.moviedb.ui.binding

import android.widget.LinearLayout.HORIZONTAL
import android.widget.LinearLayout.VERTICAL
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import com.prasad.moviedb.ui.adapter.DiscoverAdapter


object RecyclerViewBinding {

    @BindingAdapter("app:addVerticalItemDecoration")
    @JvmStatic
    fun RecyclerView.addVerticalItemDecoration(isVertical: Boolean) {
        addItemDecoration(DividerItemDecoration(context, if (isVertical) VERTICAL else HORIZONTAL))
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun setListDiscover(recyclerView: RecyclerView, items: List<DiscoverEntity>) {
        with(recyclerView.adapter as DiscoverAdapter?) {
            this?.setData(items)
        }
    }
/*    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, imageUrl: String) {
        Picasso.get()
            .load(imageUrl)
            .into(view)
    }*/

}