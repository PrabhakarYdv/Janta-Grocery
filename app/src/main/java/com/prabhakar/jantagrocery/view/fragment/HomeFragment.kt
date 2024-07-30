package com.prabhakar.jantagrocery.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.prabhakar.jantagrocery.R
import com.prabhakar.jantagrocery.Utils
import com.prabhakar.jantagrocery.adapters.CategoryAdapter
import com.prabhakar.jantagrocery.databinding.FragmentHomeBinding
import com.prabhakar.jantagrocery.model.CategoryModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val categoryList = ArrayList<CategoryModel>()
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        Utils.setStatusBarColor(requireActivity(), R.color.orange)
        buildCategoryLIst()
        setCategoryRecyclerView()

        return binding.root
    }

    private fun buildCategoryLIst() {
        categoryList.add(CategoryModel(R.drawable.vegetable, "Vegetables & Fruits"))
        categoryList.add(CategoryModel(R.drawable.dairy_breakfast, "Dairy & Breakfast"))
        categoryList.add(CategoryModel(R.drawable.munchies, "Munchies"))
        categoryList.add(CategoryModel(R.drawable.cold_and_juices, "Cold Drinks & Juices"))
        categoryList.add(CategoryModel(R.drawable.instant, "Instant & Frozen Food"))
        categoryList.add(CategoryModel(R.drawable.tea, "Tea, Coffee & Health Drinks"))
        categoryList.add(CategoryModel(R.drawable.bakery_biscuits, "Bakery & Biscuits"))
        categoryList.add(CategoryModel(R.drawable.sweet_tooth, "Sweet Tooth"))
        categoryList.add(CategoryModel(R.drawable.aata_rice, "Aata, Rice & Dal"))
        categoryList.add(CategoryModel(R.drawable.masala, "Dry Fruits, Masala & Oil"))
        categoryList.add(CategoryModel(R.drawable.sauce_spreads, "Sauces & Spreads"))
        categoryList.add(CategoryModel(R.drawable.chicken_meat, "Chicken Meat & FIsh"))
        categoryList.add(CategoryModel(R.drawable.pen_corner, "Pen Corner"))
        categoryList.add(CategoryModel(R.drawable.organic_premium, "Organic & Premium"))
        categoryList.add(CategoryModel(R.drawable.baby, "Baby Care"))
        categoryList.add(CategoryModel(R.drawable.pharma_wellness, "Pharma & Wellness"))
        categoryList.add(CategoryModel(R.drawable.cleaning, "Cleaning Essential"))
        categoryList.add(CategoryModel(R.drawable.home_office, "Home & Office"))
        categoryList.add(CategoryModel(R.drawable.personal_care, "Personal Care"))
        categoryList.add(CategoryModel(R.drawable.pet_care, "Pet Care"))
    }

    private fun setCategoryRecyclerView() {
        categoryAdapter = CategoryAdapter(categoryList)
        binding.categoriesRecyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        binding.categoriesRecyclerView.adapter = categoryAdapter
    }
}