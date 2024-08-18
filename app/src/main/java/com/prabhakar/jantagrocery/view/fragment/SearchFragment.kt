package com.prabhakar.jantagrocery.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.prabhakar.jantagrocery.adapters.ProductAdapter
import com.prabhakar.jantagrocery.databinding.FragmentSearchBinding
import com.prabhakar.jantagrocery.model.ProductModel
import com.prabhakar.jantagrocery.viewmodels.UserViewModel
import kotlinx.coroutines.launch


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(layoutInflater)


        getAllProduct()
        searchProduct()
        return binding.root
    }

    private fun getAllProduct() {
        binding.shimmerEffect.visibility = View.VISIBLE
        lifecycleScope.launch {
            userViewModel.fetchAllProduct().collect {
                binding.shimmerEffect.visibility = View.GONE
                if (it.isEmpty()) {
                    binding.nothing.visibility = View.VISIBLE
                    binding.productRecyclerView.visibility = View.GONE
                } else {
                    binding.nothing.visibility = View.GONE
                    binding.productRecyclerView.visibility = View.VISIBLE
                }
                adapter = ProductAdapter()
                binding.productRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.productRecyclerView.adapter = adapter
                adapter.differ.submitList(it as ArrayList<ProductModel>)
                adapter.originalList = it as ArrayList<ProductModel>
                binding.shimmerEffect.visibility = View.GONE
                binding.productRecyclerView.visibility = View.VISIBLE
            }
        }
    }

    private fun searchProduct() {
        binding.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(str: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val query = str.toString().trim()
                adapter.filter.filter(query)
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

}