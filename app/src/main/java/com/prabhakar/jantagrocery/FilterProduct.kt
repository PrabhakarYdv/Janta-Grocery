package com.prabhakar.jantagrocery

import android.widget.Filter
import com.prabhakar.jantagrocery.adapters.ProductAdapter
import com.prabhakar.jantagrocery.model.ProductModel
import java.util.Locale

class FilterProduct(
    private val adapter: ProductAdapter,
    private val productList: ArrayList<ProductModel>
) : Filter() {
    override fun performFiltering(constarint: CharSequence?): FilterResults {
        val result = FilterResults()
        if (constarint.isNullOrEmpty()) {
            val filterList = ArrayList<ProductModel>()
            val query = constarint.toString().trim().lowercase(Locale.getDefault()).split(" ")
            for (product in productList) {
                if (query.any {
                        product.productName?.lowercase(Locale.getDefault())
                            ?.contains(it) == true
                        product.productCategory?.lowercase(Locale.getDefault())
                            ?.contains(it) == true
                        product.productType?.lowercase(Locale.getDefault())
                            ?.contains(it) == true
                    }) {
                    filterList.add(product)
                }
            }
            result.values = filterList
            result.count = filterList.size
        } else {
            result.values = productList
            result.count = productList.size
        }
        return result
    }

    override fun publishResults(p0: CharSequence?, result: FilterResults?) {
        adapter.differ.submitList(result?.values as ArrayList<ProductModel>?)
    }
}