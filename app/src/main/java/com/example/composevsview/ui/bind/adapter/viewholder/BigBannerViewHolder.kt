package com.example.composevsview.ui.bind.adapter.viewholder

import com.bumptech.glide.Glide
import com.example.composevsview.common.adapter.banner.BannerViewHolder
import com.example.composevsview.common.adapter.banner.model.BigBanner
import com.example.composevsview.databinding.ItemBigBannerBindingBinding

class BigBannerViewHolder(
    private val binding: ItemBigBannerBindingBinding
) : BannerViewHolder<BigBanner>(binding.root) {

    override fun bind(item: BigBanner) {
        binding.title.text = item.title
        binding.subtitle.text = item.subtitle

        binding.leftImage.setImageBitmap(null)

        Glide.with(binding.leftImage)
            .clear(binding.leftImage)
        Glide.with(binding.leftImage)
            .load(item.iconFrontUrl)
            .into(binding.leftImage)

        binding.rightImage.setImageBitmap(null)
        Glide.with(binding.rightImage)
            .clear(binding.rightImage)
        Glide.with(binding.rightImage)
            .load(item.iconBackUrl)
            .into(binding.rightImage)
    }

    override fun changeTitle(title: String) {
        binding.title.text = title
    }
}
