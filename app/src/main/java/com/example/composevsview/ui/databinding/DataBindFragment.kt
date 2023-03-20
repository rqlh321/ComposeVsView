package com.example.composevsview.ui.databinding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.composevsview.MainViewModel
import com.example.composevsview.R
import com.example.composevsview.databinding.FragmentDataBindingBinding

class DataBindFragment : Fragment(R.layout.fragment_data_binding) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentDataBindingBinding.bind(view)

        val mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        mainViewModel.banners.observe(viewLifecycleOwner, binding::setList)

//        binding.lifecycleOwner = this
    }
}