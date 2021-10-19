package com.example.androidui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.adapters.AllRestaurantsAdapter
import com.example.androidui.data.AllRestaurants
import kotlinx.android.synthetic.main.fragment_all_restaurant.*


class AllRestaurantFragment : Fragment(R.layout.fragment_all_restaurant) {

    private var allRestaurantsAdapter = AllRestaurantsAdapter(
        listOf(
            AllRestaurants(R.mipmap.all_restaurants11, "McDonald's"),
            AllRestaurants(R.mipmap.all_restaurants12, "Cafe Brichor’s"),
            AllRestaurants(R.mipmap.all_restaurants13, "Mayfield Bakery & Cafe"),
            AllRestaurants(R.mipmap.all_restaurants11, "McDonald's"),
            AllRestaurants(R.mipmap.all_restaurants12, "Cafe Brichor’s"),
            AllRestaurants(R.mipmap.all_restaurants13, "Mayfield Bakery & Cafe"),
            AllRestaurants(R.mipmap.all_restaurants11, "McDonald's"),
            AllRestaurants(R.mipmap.all_restaurants12, "Cafe Brichor’s"),
            AllRestaurants(R.mipmap.all_restaurants13, "Mayfield Bakery & Cafe"),
            AllRestaurants(R.mipmap.all_restaurants11, "McDonald's"),
            AllRestaurants(R.mipmap.all_restaurants12, "Cafe Brichor’s"),
            AllRestaurants(R.mipmap.all_restaurants13, "Mayfield Bakery & Cafe")
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvAllRestaurants.adapter = allRestaurantsAdapter
        rvAllRestaurants.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL,false)

    }

}