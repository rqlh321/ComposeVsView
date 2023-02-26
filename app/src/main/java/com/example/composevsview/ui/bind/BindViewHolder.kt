package com.example.composevsview.ui.bind

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.composevsview.common.model.SmallBanner
import com.example.composevsview.databinding.ItemBindingBinding

class BindViewHolder(
    private val binding: ItemBindingBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SmallBanner) {
        binding.image.setImageDrawable(null)
        binding.title.text = item.title
        binding.subtitle.text = item.subtitle

        Glide.with(binding.image)
            .clear(binding.image)

        Glide.with(binding.image)
            .load(item.iconUrl)
            .into(binding.image)
    }

    fun changeTitle(title: String) {
        binding.title.text = title
    }

}
