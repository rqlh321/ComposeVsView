package com.example.composevsview.ui.combine.adapter

import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.example.composevsview.common.SmallBannerPayloadDifUtil
import com.example.composevsview.common.model.SmallBanner

class ContactComposeAdapter : ListAdapter<SmallBanner, ContactComposeViewHolder>(
    AsyncDifferConfig.Builder(SmallBannerPayloadDifUtil).build()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ContactComposeViewHolder(ComposeView(parent.context))

    override fun onBindViewHolder(
        holder: ContactComposeViewHolder,
        position: Int
    ) = holder.bind(getItem(position))

}