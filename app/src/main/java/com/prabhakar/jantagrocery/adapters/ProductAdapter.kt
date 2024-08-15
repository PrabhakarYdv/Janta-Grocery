package com.prabhakar.jantagrocery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prabhakar.jantagrocery.databinding.ProductItemLayoutBinding
import com.prabhakar.jantagrocery.model.ProductModel
import com.prabhakar.jantagrocery.viewholders.ProductViewHolder

class ProductAdapter(private val productList: ArrayList<ProductModel>) :
    RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = ProductItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(view)
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val model = productList[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}