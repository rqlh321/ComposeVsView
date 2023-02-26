package com.example.composevsview.ui.combine.adapter

import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.RecyclerView
import com.example.composevsview.common.model.SmallBanner
import com.example.composevsview.ui.compose.element.SmallBannerCompose

class ContactComposeViewHolder(
    private val view: ComposeView
) : RecyclerView.ViewHolder(view) {

    fun bind(item: SmallBanner) {
        view.setContent {
            SmallBannerCompose(item)
        }
    }

}
