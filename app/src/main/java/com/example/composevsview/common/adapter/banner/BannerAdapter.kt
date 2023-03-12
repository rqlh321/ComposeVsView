package com.example.composevsview.common.adapter.banner

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.example.composevsview.common.adapter.ViewHolderFactory
import com.example.composevsview.common.adapter.banner.dif.BannerPayloadDifUtil
import com.example.composevsview.common.adapter.banner.model.Banner
import com.example.composevsview.common.adapter.banner.payload.TitleChange

class BannerAdapter constructor(
    private val factory: ViewHolderFactory<BannerViewHolder<Banner>>
) : ListAdapter<Banner, BannerViewHolder<Banner>>(
    AsyncDifferConfig.Builder(BannerPayloadDifUtil).build()
) {

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