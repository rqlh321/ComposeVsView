package com.example.composevsview.ui.view.adapter

import android.view.ViewGroup
import com.example.composevsview.common.adapter.banner.BannerViewHolder
import com.example.composevsview.common.adapter.ViewHolderFactory
import com.example.composevsview.common.adapter.banner.model.Banner
import com.example.composevsview.common.adapter.banner.model.Banner.Companion.BIG_BANNER_VIEW_TYPE
import com.example.composevsview.common.adapter.banner.model.Banner.Companion.SMALL_BANNER_VIEW_TYPE
import com.example.composevsview.ui.view.adapter.viewholder.BigBannerViewHolder
import com.example.composevsview.ui.view.adapter.viewholder.SmallBannerViewHolder
import com.example.composevsview.ui.view.banner.BigBannerView
import com.example.composevsview.ui.view.banner.SmallBannerView

class CustomBannerViewHolderFactory : ViewHolderFactory<BannerViewHolder<Banner>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannerViewHolder<Banner> = when (viewType) {
        SMALL_BANNER_VIEW_TYPE -> SmallBannerViewHolder(SmallBannerView(parent.context))
        BIG_BANNER_VIEW_TYPE -> BigBannerViewHolder(BigBannerView(parent.context))
        else -> throw IllegalStateException()
    } as BannerViewHolder<Banner>
}