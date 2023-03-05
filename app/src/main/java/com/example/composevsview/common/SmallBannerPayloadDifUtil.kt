package com.example.composevsview.common

import androidx.recyclerview.widget.DiffUtil
import com.example.composevsview.common.model.Banner
import com.example.composevsview.common.model.SmallBanner
import com.example.composevsview.ui.view.adapter.payload.TitleChange

object SmallBannerPayloadDifUtil : DiffUtil.ItemCallback<SmallBanner>() {

    override fun areItemsTheSame(
        oldItem: SmallBanner,
        newItem: SmallBanner
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: SmallBanner,
        newItem: SmallBanner
    ) = oldItem == newItem

    override fun getChangePayload(
        oldItem: SmallBanner,
        newItem: SmallBanner
    ) = if (oldItem.title != newItem.title) TitleChange else null
}