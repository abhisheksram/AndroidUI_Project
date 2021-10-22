package com.example.androidui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.adapters.AllRestaurantsAdapter
import com.example.androidui.data.AllRestaurants
import com.example.androidui.databinding.FragmentAllRestaurantBinding


class AllRestaurantFragment : Fragment(R.layout.fragment_all_restaurant) {

    private var allRestaurantsAdapter = AllRestaurantsAdapter(
        listOf(
            AllRestaurants(R.mipmap.all_restaurants1, "McDonald's"),
            AllRestaurants(R.mipmap.all_restaurants2, "Cafe Brichor’s"),
            AllRestaurants(R.mipmap.all_restaurants3, "Mayfield Bakery & Cafe"),
            AllRestaurants(R.mipmap.all_restaurants1, "McDonald's"),
            AllRestaurants(R.mipmap.all_restaurants2, "Cafe Brichor’s"),
            AllRestaurants(R.mipmap.all_restaurants3, "Mayfield Bakery & Cafe"),
            AllRestaurants(R.mipmap.all_restaurants1, "McDonald's"),
            AllRestaurants(R.mipmap.all_restaurants2, "Cafe Brichor’s"),
            AllRestaurants(R.mipmap.all_restaurants3, "Mayfield Bakery & Cafe"),
            AllRestaurants(R.mipmap.all_restaurants1, "McDonald's"),
            AllRestaurants(R.mipmap.all_restaurants2, "Cafe Brichor’s"),
            AllRestaurants(R.mipmap.all_restaurants3, "Mayfield Bakery & Cafe")
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentAllRestaurantBinding.bind(view)

        binding.rvAllRestaurants.adapter = allRestaurantsAdapter
        binding.rvAllRestaurants.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL,false)

    }

}