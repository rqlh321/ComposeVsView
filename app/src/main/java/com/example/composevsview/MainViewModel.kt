package com.example.composevsview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composevsview.common.model.SmallBanner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val mutableSmallBanners = MutableLiveData<List<SmallBanner>>(emptyList())
    val smallBanners: LiveData<List<SmallBanner>> = mutableSmallBanners

    init {
        viewModelScope.launch(Dispatchers.Default) {
//            while (true) {
            mutableSmallBanners.postValue(
                (1..1000).map { SmallBanner(id = it.toString()) }
            )
//                delay(1000)
//            }
        }
    }
}