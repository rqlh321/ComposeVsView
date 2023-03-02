package com.example.composevsview.ui.view

import android.content.Context
import android.graphics.*
import android.text.DynamicLayout
import android.text.Layout
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.core.content.ContextCompat
import com.example.composevsview.R


class SmallBannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : DebugableView(context, attrs, defStyleAttr) {

    private val bannerHeight = resources.getDimension(R.dimen.small_banner_height)

    private val imageWidth = resources.getDimension(R.dimen.small_banner_image_width)
    private val imageHeight = resources.getDimension(R.dimen.small_banner_image_height)
    private val imageRadius = resources.getDimension(R.dimen.image_corner_radius)

    private val textHorizontalPadding = resources.getDimension(R.dimen.small_banner_text_horizontal_padding)
    private val textVerticalPadding = resources.getDimension(R.dimen.small_banner_text_vertical_padding)
    private val textBetweenPadding = resources.getDimension(R.dimen.small_banner_text_between_padding)

    private val titleLayout by lazy {
        DynamicLayout(
            titleText,
            titleText,
            titleTextPaint,
            width - imageWidth.toInt() - textHorizontalPadding.toInt() - textHorizontalPadding.toInt(),
            Layout.Alignment.ALIGN_NORMAL,
            1.0f,
            0f,
            true
        )
    }
    private val titleText = SpannableStringBuilder("")
    private val titleTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        textSize = resources.getDimension(R.dimen.primary_font_size)
        color = ContextCompat.getColor(context, R.color.primary_text)
    }

    private val subtitleLayout by lazy {
        DynamicLayout(
            subtitleText,
            subtitleText,
            subtitleTextPaint,
            width - imageWidth.toInt() - textHorizontalPadding.toInt() - textHorizontalPadding.toInt(),
            Layout.Alignment.ALIGN_NORMAL,
            1.0f,
            0f,
            true
        )
    }
    private val subtitleText = SpannableStringBuilder("")
    private val subtitleTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        textSize = resources.getDimension(R.dimen.secondary_font_size)
        color = ContextCompat.getColor(context, R.color.secondary_text)
    }

    private val translateXForSubtitle by lazy { imageWidth + textHorizontalPadding }
    private val translateYForTitle by lazy { subtitleLayout.height.toFloat() + textBetweenPadding }

    init {
        layoutParams = ViewGroup.LayoutParams(
            MATCH_PARENT,
            bannerHeight.toInt()
        )
    }

    private val emptyBitmap = Bitmap.createBitmap(
        imageWidth.toInt(),
        imageHeight.toInt(),
        Bitmap.Config.ARGB_8888
    )

    var image: Bitmap = emptyBitmap
        set(value) {
            val scaledInputBitmap = Bitmap.createScaledBitmap(
                value,
                imageWidth.toInt(),
                imageHeight.toInt(),
                false
            )

            val outputBitmap = Bitmap.createBitmap(
                imageWidth.toInt(),
                imageHeight.toInt(),
                Bitmap.Config.ARGB_8888
            )

            val clipPath = Path().apply {
                addRoundRect(
                    RectF(0f, 0f, imageWidth, imageHeight),
                    imageRadius,
                    imageRadius,
                    Path.Direction.CCW
                )
            }

            val canvas = Canvas(outputBitmap)
            canvas.clipPath(clipPath)
            canvas.drawBitmap(scaledInputBitmap, 0f, 0f, null)

            field = outputBitmap
            invalidate()
        }

    fun setTitle(title: String) {
        titleText.clear()
        titleText.append(title)
    }

    fun setText(title: String, subtitle: String) {
        titleText.clear()
        titleText.append(title)
        subtitleText.clear()
        subtitleText.append(subtitle)
    }

    fun clearIcon() {
        image = emptyBitmap
    }

    override fun onDraw(canvas: Canvas) {
        canvas.save()
        canvas.drawBitmap(image, 0f, 0f, null)

        canvas.translate(translateXForSubtitle, textVerticalPadding)
        subtitleLayout.draw(canvas)

        canvas.translate(0f, translateYForTitle)
        titleLayout.draw(canvas)
        super.onDraw(canvas)
    }
}