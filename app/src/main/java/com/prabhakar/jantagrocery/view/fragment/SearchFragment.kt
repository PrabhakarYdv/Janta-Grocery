package com.prabhakar.jantagrocery.view.fragment

import android.os.Bundle
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
    val userViewModel: UserViewModel by viewModels()
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(layoutInflater)

        getAllProduct()
        return binding.root
    }

    private fun getAllProduct() {
        binding.shimmerEffect.visibility = View.VISIBLE
        lifecycleScope.launch {
            userViewModel.fetchAllProduct().collect {
                if (it.isEmpty()) {
                    binding.nothing.visibility = View.VISIBLE
                    binding.productRecyclerView.visibility = View.GONE
                } else {
                    binding.nothing.visibility = View.GONE
                    binding.productRecyclerView.visibility = View.VISIBLE
                }
                adapter = ProductAdapter()
                binding.productRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
                binding.productRecyclerView.adapter
                adapter.differ.submitList(it as ArrayList<ProductModel>)
                binding.shimmerEffect.visibility = View.GONE
                binding.productRecyclerView.visibility = View.VISIBLE
            }
        }
    }


}