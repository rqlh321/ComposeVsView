package com.example.composevsview.common

import android.content.Context
import android.util.AttributeSet
import android.view.View

abstract class DesignComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr)