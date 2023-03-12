package com.example.composevsview.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.composevsview.MainViewModel
import com.example.composevsview.R
import com.example.composevsview.common.SpacingDecoration
import com.example.composevsview.common.adapter.banner.BannerAdapter
import com.example.composevsview.ui.view.adapter.CustomBannerViewHolderFactory

class CustomViewFragment : Fragment() {

    private val bannerAdapter = BannerAdapter(CustomBannerViewHolderFactory())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = RecyclerView(requireContext()).apply {
        layoutManager = LinearLayoutManager(context)
        adapter = bannerAdapter
        val big = resources.getDimensionPixelOffset(R.dimen.padding)
        val small = resources.getDimensionPixelOffset(R.dimen.item_spacing)
        addItemDecoration(SpacingDecoration(small = small, big = big))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        mainViewModel.banners.observe(viewLifecycleOwner, bannerAdapter::submitList)
    }
}