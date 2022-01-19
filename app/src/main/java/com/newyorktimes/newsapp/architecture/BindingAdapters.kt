package com.newyorktimes.newsapp.architecture

import androidx.databinding.BindingAdapter
import android.widget.ImageView
import androidx.annotation.ColorRes
import com.bumptech.glide.Glide

/****
 * Keep all static binding adapters here
 * Author: Ajay Maurya
 * Created on: 19/01/22
 * Modified on: 19/01/22
 *****/
object BindingAdapters {
    @JvmStatic
    @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.context).load(url)
            .override(150, 150)
            .centerCrop()
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("swipeListener", "colorScheme", "hideRefresh", requireAll = false)
    fun setSwipRefreshListener(
        view: androidx.swiperefreshlayout.widget.SwipeRefreshLayout,
        listener: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener?, @ColorRes color: Int?, refresh: Boolean?
    ) {
        refresh?.let {
            if (it) {
                view.isRefreshing = !it
            }
        }
        listener?.let {
            view.setOnRefreshListener(listener)
        }
        color?.let {
            view.setColorSchemeColors(it)
        }
    }
}

