package com.example.composevsview.ui.view.adapter.viewholder

import android.view.ViewGroup
import com.example.composevsview.common.model.Banner
import com.example.composevsview.common.model.Banner.Companion.BIG_BANNER_VIEW_TYPE
import com.example.composevsview.common.model.Banner.Companion.SMALL_BANNER_VIEW_TYPE
import com.example.composevsview.ui.view.adapter.viewholder.BannerViewHolder
import com.example.composevsview.ui.view.adapter.viewholder.BigBannerViewHolder
import com.example.composevsview.ui.view.adapter.viewholder.SmallBannerViewHolder
import com.example.composevsview.ui.view.banner.BigBannerView
import com.example.composevsview.ui.view.banner.SmallBannerView

class BannerViewHolderFactory {

    fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannerViewHolder<Banner> = when (viewType) {
        SMALL_BANNER_VIEW_TYPE -> SmallBannerViewHolder(SmallBannerView(parent.context))
        BIG_BANNER_VIEW_TYPE -> BigBannerViewHolder(BigBannerView(parent.context))
        else -> throw IllegalStateException()
    } as BannerViewHolder<Banner>
}