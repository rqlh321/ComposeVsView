package com.example.composevsview.ui.compose.element

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composevsview.R
import com.example.composevsview.common.model.SmallBanner

@Preview(showBackground = true)
@Composable
fun SmallBannerComposePreview() {
    SmallBannerCompose(SmallBanner("1"))
}

@Composable
fun SmallBannerCompose(item: SmallBanner) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(dimensionResource(R.dimen.small_banner_height))
    ) {
        AsyncImage(
            model = item.iconUrl,
            contentScale = ContentScale.FillBounds,
            contentDescription = item.title,
            modifier = Modifier
                .width(dimensionResource(R.dimen.small_banner_image_width))
                .height(dimensionResource(R.dimen.small_banner_image_height))
                .clip(RoundedCornerShape(dimensionResource(R.dimen.image_corner_radius)))
        )
        Column(
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(R.dimen.small_banner_text_vertical_padding),
                    horizontal = dimensionResource(R.dimen.small_banner_text_horizontal_padding),
                )
        ) {
            Text(
                text = item.subtitle,
                color = colorResource(R.color.secondary_text),
                fontSize = dimensionResource(R.dimen.secondary_font_size).value.sp,
            )
            Text(
                modifier = Modifier
                    .padding(top = dimensionResource(R.dimen.small_banner_text_between_padding)),
                text = item.title,
                color = colorResource(R.color.primary_text),
                fontSize = dimensionResource(R.dimen.primary_font_size).value.sp,
            )
        }
    }
}