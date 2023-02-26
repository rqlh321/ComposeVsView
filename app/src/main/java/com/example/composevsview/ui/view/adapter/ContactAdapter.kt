package com.example.composevsview.ui.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.example.composevsview.common.BannerPayloadDifUtil
import com.example.composevsview.common.model.SmallBanner
import com.example.composevsview.ui.view.SmallBannerView

class ContactAdapter : ListAdapter<SmallBanner, ContactViewHolder>(
    AsyncDifferConfig.Builder(BannerPayloadDifUtil).build()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ContactViewHolder(SmallBannerView(parent.context))

    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int
    ) = holder.bind(getItem(position))

    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            if (payloads[0] == true) {
                holder.changeTitle(getItem(position).title)
            }
        }
    }
}