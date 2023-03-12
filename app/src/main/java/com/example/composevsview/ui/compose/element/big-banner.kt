package com.example.composevsview.ui.compose.element

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.composevsview.R
import com.example.composevsview.common.adapter.banner.model.BigBanner
import com.example.composevsview.ui.compose.them.ExtendedTheme

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
            maxLines = 1,
            text = item.subtitle,
            style = MaterialTheme.typography.titleMedium,
            color = ExtendedTheme.colors.support,
        )
        Text(
            maxLines = 1,
            text = item.title,
            color = ExtendedTheme.colors.main,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}