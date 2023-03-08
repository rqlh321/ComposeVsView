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
import com.example.composevsview.common.model.BigBanner

@Preview(showBackground = true)
@Composable
fun BigBannerComposePreview() {
    BigBannerCompose(BigBanner("1"))
}

@Composable
fun BigBannerCompose(item: BigBanner) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.big_banner_height))
    ) {
        Row {
            AsyncImage(
                model = item.iconFrontUrl,
                contentScale = ContentScale.FillBounds,
                contentDescription = null,
                modifier = Modifier
                    .width(dimensionResource(R.dimen.big_banner_image_width))
                    .height(dimensionResource(R.dimen.big_banner_image_height))
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.image_corner_radius)))
            )
            AsyncImage(
                model = item.iconBackUrl,
                contentScale = ContentScale.FillBounds,
                contentDescription = null,
                modifier = Modifier
                    .width(dimensionResource(R.dimen.big_banner_image_width))
                    .height(dimensionResource(R.dimen.big_banner_image_height))
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.image_corner_radius)))
            )
        }
        Text(
            text = item.subtitle,
            color = colorResource(R.color.secondary_color),
            fontSize = dimensionResource(R.dimen.secondary_font_size).value.sp,
        )
        Text(
            text = item.title,
            color = colorResource(R.color.primary_color),
            fontSize = dimensionResource(R.dimen.primary_font_size).value.sp,
        )
    }
}