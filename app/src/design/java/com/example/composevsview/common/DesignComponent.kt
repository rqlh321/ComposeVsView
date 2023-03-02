package com.example.composevsview.common

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.composevsview.R
import com.example.composevsview.ui.view.adapter.InfoDrawable

abstract class DesignComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val info = InfoDrawable(
        name = this::class.java.simpleName,
        backgroundColor = ContextCompat.getColor(context, R.color.debug_view)
    )

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        info.setBounds(0, 0, width, height);
    }

    override fun onDraw(canvas: Canvas) {
        canvas.restore()
        info.draw(canvas)
    }
}