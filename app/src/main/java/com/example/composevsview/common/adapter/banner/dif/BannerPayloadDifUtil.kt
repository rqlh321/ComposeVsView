package com.example.composevsview.common.adapter.banner.dif

import androidx.recyclerview.widget.DiffUtil
import com.example.composevsview.common.adapter.banner.model.Banner
import com.example.composevsview.common.adapter.banner.payload.TitleChange

object BannerPayloadDifUtil : DiffUtil.ItemCallback<Banner>() {

    override fun areItemsTheSame(
        oldItem: Banner,
        newItem: Banner
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: Banner,
        newItem: Banner
    ) = oldItem == newItem

    override fun getChangePayload(
        oldItem: Banner,
        newItem: Banner
    ) = if (oldItem.title != newItem.title) TitleChange else null
}