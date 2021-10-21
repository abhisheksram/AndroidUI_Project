package com.example.androidui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidui.R
import com.example.androidui.adapters.TopRestaurantAdapter
import com.example.androidui.data.TopRestaurants
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(R.layout.fragment_search) {


    private var topRestaurantAdapter = TopRestaurantAdapter(
        listOf(
            TopRestaurants(R.mipmap.restaurant1, "The Halal Guys"),
            TopRestaurants(R.mipmap.restaurant2, "Popeyes 1426 Flmst"),
            TopRestaurants(R.mipmap.restaurant3, "Mixt - Yerba Buena"),
            TopRestaurants(R.mipmap.restaurant4, "Split Bread - Russian"),
            TopRestaurants(R.mipmap.restaurant5, "Cookie Sandwich"),
            TopRestaurants(R.mipmap.restaurant6, "Cookie Sandwich"),
            TopRestaurants(R.mipmap.restaurant1, "The Halal Guys"),
            TopRestaurants(R.mipmap.restaurant2, "Popeyes 1426 Flmst"),
            TopRestaurants(R.mipmap.restaurant3, "Mixt - Yerba Buena"),
            TopRestaurants(R.mipmap.restaurant4, "Split Bread - Russian"),
            TopRestaurants(R.mipmap.restaurant5, "Cookie Sandwich"),
            TopRestaurants(R.mipmap.restaurant6, "Cookie Sandwich")
        )
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        rvSearchTopRestaurants.adapter = topRestaurantAdapter
        rvSearchTopRestaurants.layoutManager = gridLayoutManager


        tvTopCategory.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_search2_to_categoriesFragment2)

        }

        tvSearchView.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_search2_to_searchItemsFragment2)

        }
    }
}