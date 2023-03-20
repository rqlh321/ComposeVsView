package com.example.composevsview.ui.databinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.composevsview.BR
import com.example.composevsview.common.adapter.ListItem
import com.example.composevsview.common.adapter.ListItemDifUtil

class DataBindingRecyclerViewAdapter :
    ListAdapter<ListItem, DataBindingViewHolder>(ListItemDifUtil) {

    override fun getItemViewType(
        position: Int
    ) = getItem(position).layout()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = DataBindingViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: DataBindingViewHolder,
        position: Int
    ) {
        holder.dataBinding.setVariable(BR.item, getItem(position))
        holder.dataBinding.executePendingBindings()
    }
}