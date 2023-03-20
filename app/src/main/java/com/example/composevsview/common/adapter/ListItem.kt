package com.example.composevsview.common.adapter

abstract class ListItem {

    abstract val id: String

    abstract fun layout(): Int

    override fun equals(other: Any?) = super.equals(other)

    override fun hashCode() = super.hashCode()

}