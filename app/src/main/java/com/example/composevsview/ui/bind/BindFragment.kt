package com.example.composevsview.ui.bind

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.composevsview.MainViewModel
import com.example.composevsview.R
import com.example.composevsview.common.SpacingDecoration
import com.example.composevsview.common.adapter.banner.BannerAdapter
import com.example.composevsview.databinding.FragmentBindBinding
import com.example.composevsview.ui.bind.adapter.BindBannerViewHolderFactory

class BindFragment : Fragment(R.layout.fragment_bind) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentBindBinding.bind(view)
        val bannerAdapter = BannerAdapter(BindBannerViewHolderFactory())
        binding.root.adapter = bannerAdapter
        val big = resources.getDimensionPixelOffset(R.dimen.padding)
        val small = resources.getDimensionPixelOffset(R.dimen.item_spacing)
        binding.root.addItemDecoration(SpacingDecoration(small = small, big = big))

        val mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        mainViewModel.banners.observe(viewLifecycleOwner, bannerAdapter::submitList)
    }
}