package com.example.composevsview.ui.litho

import com.example.composevsview.MainViewModel
import com.example.composevsview.R
import com.example.composevsview.common.SpacingDecoration
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.litho.*
import com.facebook.litho.core.margin
import com.facebook.litho.core.padding
import com.facebook.litho.fresco.FrescoImage
import com.facebook.litho.kotlin.widget.Text
import com.facebook.litho.livedata.useLiveData
import com.facebook.litho.widget.collection.LazyList

class BannersColumn(private val viewModel: MainViewModel) : KComponent() {

    override fun ComponentScope.render(): Component {
        val banners = useLiveData(viewModel.smallBanners) ?: error("should not be null")
        return LazyList(
            itemDecoration = SpacingDecoration(
                big = dimenRes(R.dimen.padding).encodedValue.toInt(),
                small = dimenRes(R.dimen.item_spacing).encodedValue.toInt()
            ),
        ) {
            children(
                items = banners,
                id = { it.id }
            ) {
                Row {
                    child(
                        FrescoImage.create(context)
                            .widthPx(dimenRes(R.dimen.small_banner_image_width).encodedValue.toInt())
                            .heightPx(dimenRes(R.dimen.small_banner_image_height).encodedValue.toInt())
                            .actualImageScaleType(ScalingUtils.ScaleType.FIT_START)
                            .controller(getImageController(it.iconUrl))
                            .build()
                    )
                    child(
                        Column(
                            style = Style.padding(
                                all = dimenRes(R.dimen.small_banner_text_vertical_padding)
                            )
                        ) {
                            child(
                                Text(
                                    text = it.subtitle,
                                    textSize = dimenRes(R.dimen.secondary_font_size)
                                )
                            )
                            child(
                                Text(
                                    text = it.title,
                                    textSize = dimenRes(R.dimen.primary_font_size),
                                    style = Style.margin(
                                        top = dimenRes(R.dimen.small_banner_text_spacing),
                                    )
                                )
                            )
                        }
                    )
                }
            }
        }
    }

    private fun getImageController(
        imageUrl: String
    ) = Fresco.newDraweeControllerBuilder()
        .setUri(imageUrl)
        .build()
}