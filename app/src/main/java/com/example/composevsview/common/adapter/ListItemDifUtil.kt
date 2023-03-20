package com.example.composevsview.common.adapter

import androidx.recyclerview.widget.DiffUtil

object ListItemDifUtil : DiffUtil.ItemCallback<ListItem>() {

    override fun areItemsTheSame(
        oldItem: ListItem,
        newItem: ListItem
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: ListItem,
        newItem: ListItem
    ) = oldItem == newItem

}