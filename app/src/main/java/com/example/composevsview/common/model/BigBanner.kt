package com.example.composevsview.common.model

import java.util.*

data class BigBanner(
    override val id: String,
    override val title: String = UUID.randomUUID().toString(),
    val subtitle: String = "Position $id",
    val iconFrontUrl: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png",
    val iconBackUrl: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/$id.png",
) : Banner() {
    override fun viewType() = BIG_BANNER_VIEW_TYPE

}