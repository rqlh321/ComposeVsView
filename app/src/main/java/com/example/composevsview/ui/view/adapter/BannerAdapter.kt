package com.example.composevsview.ui.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.example.composevsview.common.BannerPayloadDifUtil
import com.example.composevsview.common.model.Banner
import com.example.composevsview.ui.view.adapter.payload.TitleChange
import com.example.composevsview.ui.view.adapter.viewholder.BannerViewHolder
import com.example.composevsview.ui.view.adapter.viewholder.BannerViewHolderFactory

class BannerAdapter : ListAdapter<Banner, BannerViewHolder<Banner>>(
    AsyncDifferConfig.Builder(BannerPayloadDifUtil).build()
) {

    private val factory = BannerViewHolderFactory()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = factory.onCreateViewHolder(parent, viewType)

    override fun onBindViewHolder(
        holder: BannerViewHolder<Banner>,
        position: Int
    ) = holder.bind(getItem(position))

    override fun getItemViewType(
        position: Int
    ) = getItem(position).viewType()

    override fun onBindViewHolder(
        holder: BannerViewHolder<Banner>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            payloads.forEach {
                when (it) {
                    is TitleChange -> holder.changeTitle(getItem(position).title)
                    else -> super.onBindViewHolder(holder, position, payloads)
                }
            }
        }
    }
}