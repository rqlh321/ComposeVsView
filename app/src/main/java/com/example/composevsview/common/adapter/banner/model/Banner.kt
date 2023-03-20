package com.example.composevsview.common.adapter.banner.model

import com.example.composevsview.common.adapter.ListItem

abstract class Banner : ListItem() {
    abstract override val id: String
    abstract val title: String

    abstract fun viewType(): Int

    companion object {
        const val SMALL_BANNER_VIEW_TYPE = 0
        const val BIG_BANNER_VIEW_TYPE = 1
    }
}