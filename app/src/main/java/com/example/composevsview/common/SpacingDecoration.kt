package com.example.composevsview.common

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingDecoration(
    private val small: Int,
    private val big: Int,
) : RecyclerView.ItemDecoration() {

    private val left = big
    private val right = big

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        recyclerView: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = recyclerView.getChildAdapterPosition(view)
        val (top, bottom) = when (position) {
            0 -> big to 0
            ((recyclerView.adapter?.itemCount ?: 0) - 1) -> small to big
            else -> small to 0
        }
        outRect.set(left, top, right, bottom)
    }
}