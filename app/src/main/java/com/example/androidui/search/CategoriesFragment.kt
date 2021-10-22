package com.example.androidui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidui.R
import com.example.androidui.adapters.CategoriesAdapter
import com.example.androidui.data.Categories
import com.example.androidui.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    private var categoriesAdapter = CategoriesAdapter(
        listOf(
            Categories(R.mipmap.categories1, "Fast Food"),
            Categories(R.mipmap.categories2, "Breakfast & Brunch"),
            Categories(R.mipmap.categories3, "Mexican"),
            Categories(R.mipmap.categories4, "Bakery"),
            Categories(R.mipmap.categories5, "Deserts"),
            Categories(R.mipmap.categories6, "Burgers"),
            Categories(R.mipmap.categories1, "Fast Food"),
            Categories(R.mipmap.categories2, "Breakfast & Brunch"),
            Categories(R.mipmap.categories3, "Mexican"),
            Categories(R.mipmap.categories4, "Bakery"),
            Categories(R.mipmap.categories5, "Deserts"),
            Categories(R.mipmap.categories6, "Burgers"),
            Categories(R.mipmap.categories1, "Fast Food"),
            Categories(R.mipmap.categories2, "Breakfast & Brunch"),
            Categories(R.mipmap.categories3, "Mexican"),
            Categories(R.mipmap.categories4, "Bakery"),
            Categories(R.mipmap.categories5, "Deserts"),
            Categories(R.mipmap.categories6, "Burgers")
        )
    )

    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCategoriesBinding.bind(view)

        gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.rvCategories.adapter = categoriesAdapter
        binding.rvCategories.layoutManager = gridLayoutManager

    }
}