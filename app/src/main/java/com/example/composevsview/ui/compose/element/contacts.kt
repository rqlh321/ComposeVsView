package com.example.composevsview.ui.compose.element

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.composevsview.R
import com.example.composevsview.common.model.SmallBanner

@Composable
fun Banners(items: List<SmallBanner>) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(
        state = listState,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.between)),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding)),
        modifier = Modifier.fillMaxHeight()
    ) {
        items(
            items = items,
            contentType = { it::class },
            key = { it.id },
        ) {
            SmallBannerCompose(it)
        }
    }
}

