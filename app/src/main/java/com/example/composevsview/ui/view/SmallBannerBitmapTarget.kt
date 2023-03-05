package com.example.composevsview.ui.view

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.composevsview.ui.view.banner.SmallBannerView

class SmallBannerBitmapTarget(private val view: SmallBannerView) : CustomTarget<Bitmap>() {
    override fun onResourceReady(
        resource: Bitmap,
        transition: Transition<in Bitmap>?
    ) {
        view.image = resource
    }

    override fun onLoadCleared(placeholder: Drawable?) = Unit

}