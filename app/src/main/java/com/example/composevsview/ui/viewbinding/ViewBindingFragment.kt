package com.example.composevsview.ui.viewbinding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.composevsview.MainViewModel
import com.example.composevsview.R
import com.example.composevsview.common.SpacingDecoration
import com.example.composevsview.common.adapter.banner.BannerAdapter
import com.example.composevsview.databinding.FragmentViewBindingBinding
import com.example.composevsview.ui.viewbinding.adapter.BindBannerViewHolderFactory

class ViewBindingFragment : Fragment(R.layout.fragment_view_binding) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentViewBindingBinding.bind(view)
        val bannerAdapter = BannerAdapter(BindBannerViewHolderFactory())
        binding.root.adapter = bannerAdapter
        binding.root.addItemDecoration(SpacingDecoration(requireContext()))

        val mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        mainViewModel.banners.observe(viewLifecycleOwner, bannerAdapter::submitList)
    }
}