package com.example.composevsview.ui.view.adapter.viewholder

import com.bumptech.glide.Glide
import com.example.composevsview.common.adapter.banner.BannerViewHolder
import com.example.composevsview.common.adapter.banner.model.SmallBanner
import com.example.composevsview.ui.view.SmallBannerBitmapTarget
import com.example.composevsview.ui.view.banner.SmallBannerView

class SmallBannerViewHolder(
    private val view: SmallBannerView
) : BannerViewHolder<SmallBanner>(view) {

    private val target = SmallBannerBitmapTarget(view)

    override fun bind(item: SmallBanner) {
        view.setText(item.title, item.subtitle)
        view.clearIcon()

        Glide.with(view)
            .clear(target)
        Glide.with(view)
            .asBitmap()
            .load(item.iconUrl)
            .into(target)
    }

    override fun changeTitle(title: String) {
        view.setTitle(title)
    }
}
