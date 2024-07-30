package com.prabhakar.jantagrocery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prabhakar.jantagrocery.databinding.CategoryLayoutBinding
import com.prabhakar.jantagrocery.model.CategoryModel
import com.prabhakar.jantagrocery.viewholders.CategoryViewHolder

class CategoryAdapter(private val categoryList: ArrayList<CategoryModel>) :
    RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = CategoryLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(view)
    }


    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val model = categoryList[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}