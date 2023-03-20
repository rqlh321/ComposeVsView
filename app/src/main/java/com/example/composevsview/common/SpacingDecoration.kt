package com.example.composevsview.common

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.composevsview.R

class SpacingDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val big = context.resources.getDimensionPixelOffset(R.dimen.padding)
    private val small = context.resources.getDimensionPixelOffset(R.dimen.item_spacing)

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