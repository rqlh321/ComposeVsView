package com.example.composevsview.ui.litho

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.composevsview.MainViewModel
import com.facebook.litho.AOSPLithoLifecycleProvider
import com.facebook.litho.LithoView

class LithoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = LithoView.create(
        requireContext(),
        BannersColumn(ViewModelProvider(requireActivity())[MainViewModel::class.java]),
        AOSPLithoLifecycleProvider(this)
    )
}