package com.example.composevsview.ui.bind

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import com.example.composevsview.common.BannerPayloadDifUtil
import com.example.composevsview.common.model.SmallBanner
import com.example.composevsview.databinding.ItemBindingBinding

class BindAdapter : ListAdapter<SmallBanner, BindViewHolder>(
    AsyncDifferConfig.Builder(BannerPayloadDifUtil).build()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = BindViewHolder(
        ItemBindingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
    )

    override fun onBindViewHolder(
        holder: BindViewHolder,
        position: Int
    ) = holder.bind(getItem(position))

    override fun onBindViewHolder(
        holder: BindViewHolder,
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