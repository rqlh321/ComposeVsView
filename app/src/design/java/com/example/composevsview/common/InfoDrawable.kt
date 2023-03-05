package com.example.composevsview.common

import android.graphics.*
import android.graphics.drawable.Drawable

class InfoDrawable(
    private val name: String,
    private val backgroundColor: Int,
) : Drawable() {

    private val paint: Paint = Paint()

    private val textWidth: Float

    init {
        paint.color = Color.WHITE
        paint.textSize = TEXT_SIZE
        paint.isAntiAlias = true
        paint.isFakeBoldText = true
        paint.setShadowLayer(6f, 0f, 0f, Color.BLACK)
        paint.style = Paint.Style.FILL
        paint.textAlign = Paint.Align.LEFT
        textWidth = paint.measureText(name)
    }

    override fun draw(canvas: Canvas) {
        canvas.drawColor(backgroundColor)
        canvas.drawText(name, 0f, TEXT_SIZE, paint)
    }

    override fun setAlpha(alpha: Int) = Unit

    override fun setColorFilter(cf: ColorFilter?) = Unit

    @Deprecated("Deprecated in Java")
    override fun getOpacity() = PixelFormat.TRANSLUCENT

    companion object {
        private const val TEXT_SIZE = 36f
    }
}