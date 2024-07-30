package com.prabhakar.jantagrocery.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.prabhakar.jantagrocery.databinding.CategoryLayoutBinding
import com.prabhakar.jantagrocery.model.CategoryModel

class CategoryViewHolder(private val binding: CategoryLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setData(model: CategoryModel) {
        binding.apply {
            categoryImage.setImageResource(model.categoryImage)
            categoryName.text = model.categoryName
        }
    }
}