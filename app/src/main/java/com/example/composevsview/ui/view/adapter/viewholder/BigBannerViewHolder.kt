package com.example.composevsview.ui.view.adapter.viewholder

import com.bumptech.glide.Glide
import com.example.composevsview.common.adapter.banner.BannerViewHolder
import com.example.composevsview.common.adapter.banner.model.BigBanner
import com.example.composevsview.ui.view.banner.BigBannerView

class BigBannerViewHolder(
    private val view: BigBannerView
) : BannerViewHolder<BigBanner>(view) {

    override fun bind(item: BigBanner) {
        view.title.text = item.title
        view.subtitle.text = item.subtitle

        view.leftImage.setImageBitmap(null)

        Glide.with(view.leftImage)
            .clear(view.leftImage)
        Glide.with(view.leftImage)
            .load(item.iconFrontUrl)
            .into(view.leftImage)

        view.rightImage.setImageBitmap(null)
        Glide.with(view.rightImage)
            .clear(view.rightImage)
        Glide.with(view.rightImage)
            .load(item.iconBackUrl)
            .into(view.rightImage)
    }

    override fun changeTitle(title: String) {
        view.title.text = title
    }
}
