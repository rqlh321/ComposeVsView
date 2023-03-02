package com.example.composevsview.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.composevsview.R
import com.example.composevsview.ui.view.adapter.TextDrawable

abstract class DebugableView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val info = LayerDrawable(
        arrayOf(
            ColorDrawable(ContextCompat.getColor(context, R.color.debug_view)),
            TextDrawable(this::class.java.simpleName)
        )
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