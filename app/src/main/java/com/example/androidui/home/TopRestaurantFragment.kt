package com.example.androidui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidui.R
import com.example.androidui.adapters.TopRestaurantAdapter
import com.example.androidui.data.TopRestaurants
import kotlinx.android.synthetic.main.fragment_top_restaurant.*

class TopRestaurantFragment : Fragment(R.layout.fragment_top_restaurant) {

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

    private lateinit var gridLayoutManager : GridLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        rvTopRestaurants.adapter = topRestaurantAdapter
        rvTopRestaurants.layoutManager = gridLayoutManager

    }
}