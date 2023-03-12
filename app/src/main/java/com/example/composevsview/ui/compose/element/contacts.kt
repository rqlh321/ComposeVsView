package com.example.composevsview.ui.compose.element

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composevsview.MainViewModel
import com.example.composevsview.R
import com.example.composevsview.common.adapter.banner.model.BigBanner
import com.example.composevsview.common.adapter.banner.model.SmallBanner

@Composable
fun ComposeScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val banners = viewModel.banners.observeAsState()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.item_spacing)),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding)),
        modifier = Modifier.fillMaxHeight()
    ) {
        items(
            items = banners.value ?: emptyList(),
            contentType = { it::class },
            key = { it.id },
        ) {
            when (it) {
                is SmallBanner -> SmallBannerCompose(it)
                is BigBanner -> BigBannerCompose(it)
            }
        }
    }
}

