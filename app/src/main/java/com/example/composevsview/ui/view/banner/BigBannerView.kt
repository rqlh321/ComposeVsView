package com.example.composevsview.ui.view.banner

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.composevsview.R
import com.example.composevsview.common.ConstraintDesignComponent

class BigBannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintDesignComponent(context, attrs, defStyleAttr) {

    val leftImage by lazy { findViewById<ImageView>(R.id.left_image_id) }
    val rightImage by lazy { findViewById<ImageView>(R.id.right_image_id) }
    val title by lazy { findViewById<TextView>(R.id.title_id) }
    val subtitle by lazy { findViewById<TextView>(R.id.subtitle_id) }

    init {
        layoutParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            resources.getDimension(R.dimen.big_banner_height).toInt()
        )
        inflate(context, R.layout.item_big_banner, this)
    }
}