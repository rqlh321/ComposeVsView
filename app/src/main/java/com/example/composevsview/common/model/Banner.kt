package com.example.composevsview.common.model

abstract class Banner {
    abstract val id: String
    abstract val title: String

    override fun equals(other: Any?) = super.equals(other)

    override fun hashCode() = super.hashCode()

    abstract fun viewType(): Int

    companion object {
        const val SMALL_BANNER_VIEW_TYPE = 0
        const val BIG_BANNER_VIEW_TYPE = 1
    }
}