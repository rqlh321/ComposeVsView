package com.example.composevsview.common

import androidx.recyclerview.widget.DiffUtil
import com.example.composevsview.common.model.Banner
import com.example.composevsview.ui.view.adapter.payload.TitleChange

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