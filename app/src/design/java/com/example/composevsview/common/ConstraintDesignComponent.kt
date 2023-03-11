package com.example.composevsview.common

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.composevsview.R

abstract class ConstraintDesignComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        background = InfoDrawable(
            name = this::class.java.simpleName,
            backgroundColor = ContextCompat.getColor(context, R.color.transparent_red)
        )
    }

}