package com.example.composevsview.ui.view.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.composevsview.common.model.Banner

abstract class BannerViewHolder<T : Banner>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T)
    abstract fun changeTitle(title: String)
}