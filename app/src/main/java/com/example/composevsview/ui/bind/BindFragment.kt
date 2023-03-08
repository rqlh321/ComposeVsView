package com.example.composevsview.ui.bind

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.composevsview.MainViewModel
import com.example.composevsview.R
import com.example.composevsview.common.SpacingDecoration
import com.example.composevsview.databinding.FragmentBindBinding

class BindFragment : Fragment(R.layout.fragment_bind) {

    private val bindAdapter = BindAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentBindBinding.bind(view)
        binding.root.adapter = bindAdapter
        val big = resources.getDimensionPixelOffset(R.dimen.padding)
        val small = resources.getDimensionPixelOffset(R.dimen.item_spacing)
        binding.root.addItemDecoration(SpacingDecoration(small = small, big = big))

        val mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        mainViewModel.smallBanners.observe(viewLifecycleOwner, bindAdapter::submitList)
    }
}