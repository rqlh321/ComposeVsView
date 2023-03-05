package com.example.composevsview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composevsview.common.model.Banner
import com.example.composevsview.common.model.BigBanner
import com.example.composevsview.common.model.SmallBanner
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random

@HiltViewModel
class MainViewModel : ViewModel() {

    private val mutableSmallBanners = MutableLiveData<List<SmallBanner>>(emptyList())
    val smallBanners: LiveData<List<SmallBanner>> = mutableSmallBanners
    private val mixedBannersMut = MutableLiveData<List<Banner>>(emptyList())
    val banners: LiveData<List<Banner>> = mixedBannersMut

    init {
        viewModelScope.launch(Dispatchers.Default) {
            mutableSmallBanners.postValue(
                (1..1000).map { SmallBanner(id = it.toString()) }
            )
            mixedBannersMut.postValue(
                (1..1000).map {
                    if (Random.nextBoolean())
                        SmallBanner(id = it.toString()) else BigBanner(id = it.toString())
                }
            )
        }
    }
}