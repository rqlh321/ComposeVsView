package com.example.composevsview.common.adapter.banner.model

import com.example.composevsview.R
import java.util.*

data class SmallBanner(
    override val id: String,
    override val title: String = UUID.randomUUID().toString(),
    val subtitle: String = "Position $id",
    val iconUrl: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png",
) : Banner() {
    override fun viewType() = SMALL_BANNER_VIEW_TYPE
    override fun layout() = R.layout.item_data_binding_small_banner

}