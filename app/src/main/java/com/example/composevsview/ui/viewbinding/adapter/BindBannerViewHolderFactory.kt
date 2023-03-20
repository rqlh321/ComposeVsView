package com.example.composevsview.ui.viewbinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.composevsview.common.adapter.ViewHolderFactory
import com.example.composevsview.common.adapter.banner.BannerViewHolder
import com.example.composevsview.common.adapter.banner.model.Banner
import com.example.composevsview.common.adapter.banner.model.Banner.Companion.BIG_BANNER_VIEW_TYPE
import com.example.composevsview.common.adapter.banner.model.Banner.Companion.SMALL_BANNER_VIEW_TYPE
import com.example.composevsview.databinding.ItemViewBindingBigBannerBinding
import com.example.composevsview.databinding.ItemViewBindingSmallBannerBinding
import com.example.composevsview.ui.viewbinding.adapter.viewholder.BigBannerViewHolder
import com.example.composevsview.ui.viewbinding.adapter.viewholder.SmallBannerViewHolder

class BindBannerViewHolderFactory : ViewHolderFactory<BannerViewHolder<Banner>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannerViewHolder<Banner> = when (viewType) {
        BIG_BANNER_VIEW_TYPE -> BigBannerViewHolder(
            ItemViewBindingBigBannerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        SMALL_BANNER_VIEW_TYPE -> SmallBannerViewHolder(
            ItemViewBindingSmallBannerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        else -> throw IllegalStateException()
    } as BannerViewHolder<Banner>
}