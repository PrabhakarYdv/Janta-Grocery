package com.prabhakar.jantagrocery.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.prabhakar.jantagrocery.databinding.ProductItemLayoutBinding
import com.prabhakar.jantagrocery.model.ProductModel

class ProductViewHolder(val binding: ProductItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setData(model: ProductModel) {
        binding.apply {
            productName.text = model.productName
            quantity.text = model.productQuantity.toString() + model.productUnit
            price.text = "₹" + model.productPrice.toString()
        }
    }
}