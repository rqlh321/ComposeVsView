package com.example.composevsview.ui.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.composevsview.common.model.SmallBanner
import com.example.composevsview.ui.view.SmallBannerBitmapTarget
import com.example.composevsview.ui.view.SmallBannerView

class ContactViewHolder(
    private val view: SmallBannerView
) : RecyclerView.ViewHolder(view) {

    private val target = SmallBannerBitmapTarget(view)

    fun bind(item: SmallBanner) {
        view.setText(item.title, item.subtitle)
        view.clearIcon()

        Glide.with(view)
            .clear(target)
        Glide.with(view)
            .asBitmap()
            .load(item.iconUrl)
            .into(target)
    }

    fun changeTitle(title: String) {
        view.setTitle(title)
    }
}
