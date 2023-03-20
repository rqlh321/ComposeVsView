package com.example.composevsview.ui.databinding.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.composevsview.common.SpacingDecoration
import com.example.composevsview.common.adapter.ListItem

@BindingAdapter("android:imageUrl")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view).clear(view)
    Glide.with(view).load(url).into(view)
}

@BindingAdapter("android:updateList")
fun updateList(view: RecyclerView, list: List<ListItem>) {
    if (view.adapter == null) {
        view.addItemDecoration(SpacingDecoration(view.context))
        view.adapter = DataBindingRecyclerViewAdapter()
            .apply { submitList(list) }
    } else {
        view.adapter?.let { it as? DataBindingRecyclerViewAdapter }
            ?.submitList(list)
    }
}
