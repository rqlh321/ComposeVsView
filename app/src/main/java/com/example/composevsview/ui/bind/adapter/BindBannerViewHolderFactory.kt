package com.example.composevsview.ui.bind.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.composevsview.common.adapter.ViewHolderFactory
import com.example.composevsview.common.adapter.banner.BannerViewHolder
import com.example.composevsview.common.adapter.banner.model.Banner
import com.example.composevsview.common.adapter.banner.model.Banner.Companion.BIG_BANNER_VIEW_TYPE
import com.example.composevsview.common.adapter.banner.model.Banner.Companion.SMALL_BANNER_VIEW_TYPE
import com.example.composevsview.databinding.ItemBigBannerBindingBinding
import com.example.composevsview.databinding.ItemSmallBannerBindingBinding
import com.example.composevsview.ui.bind.adapter.viewholder.BigBannerViewHolder
import com.example.composevsview.ui.bind.adapter.viewholder.SmallBannerViewHolder

class BindBannerViewHolderFactory : ViewHolderFactory<BannerViewHolder<Banner>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannerViewHolder<Banner> = when (viewType) {
        BIG_BANNER_VIEW_TYPE -> BigBannerViewHolder(
            ItemBigBannerBindingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        SMALL_BANNER_VIEW_TYPE -> SmallBannerViewHolder(
            ItemSmallBannerBindingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        else -> throw IllegalStateException()
    } as BannerViewHolder<Banner>
}