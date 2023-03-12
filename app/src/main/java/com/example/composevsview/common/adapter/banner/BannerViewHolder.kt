package com.example.composevsview.common.adapter.banner

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.composevsview.common.adapter.banner.model.Banner

abstract class BannerViewHolder<T : Banner>(
    view: View
) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T)
    abstract fun changeTitle(title: String)
}