package com.example.composevsview.ui.viewbinding.adapter.viewholder

import com.bumptech.glide.Glide
import com.example.composevsview.common.adapter.banner.BannerViewHolder
import com.example.composevsview.common.adapter.banner.model.SmallBanner
import com.example.composevsview.databinding.ItemViewBindingSmallBannerBinding

class SmallBannerViewHolder(
    private val binding: ItemViewBindingSmallBannerBinding,
) : BannerViewHolder<SmallBanner>(binding.root) {

    override fun bind(item: SmallBanner) {
        binding.image.setImageDrawable(null)
        binding.title.text = item.title
        binding.subtitle.text = item.subtitle

        Glide.with(binding.image)
            .clear(binding.image)

        Glide.with(binding.image)
            .load(item.iconUrl)
            .into(binding.image)
    }

    override fun changeTitle(title: String) {
        binding.title.text = title
    }

}
