package com.example.composevsview.common.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class ViewHolderFactory<T : RecyclerView.ViewHolder> {
    abstract fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T
}