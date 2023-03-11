package com.example.composevsview.ui.compose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composevsview.ui.compose.element.ComposeScreen
import com.example.composevsview.ui.compose.them.AppTheme
import com.example.composevsview.ui.compose.them.Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = ComposeView(requireContext()).apply {
        setContent { AppTheme(Theme.MAIN) { ComposeScreen(hiltViewModel(requireActivity())) } }
    }
}