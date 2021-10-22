package com.example.androidui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.adapters.SingleRestaurantAdapter
import com.example.androidui.data.SingleRestaurant
import com.example.androidui.databinding.FragmentSingleRestaurantTabBinding


class SingleRestaurantTabFragment : Fragment(R.layout.fragment_single_restaurant_tab) {

    private var singleRestaurantAdapter1 = SingleRestaurantAdapter(
        listOf(
            SingleRestaurant(
                R.mipmap.food1, "Cookie Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.mipmap.food2, "Combo Burger",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.mipmap.food3, "Combo Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.mipmap.food1, "Cookie Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.mipmap.food2, "Combo Burger",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.mipmap.food3, "Combo Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet."
            )
        )
    )

    private var singleRestaurantAdapter2 = SingleRestaurantAdapter(
        listOf(
            SingleRestaurant(
                R.mipmap.food11, "Oyster Dish",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.mipmap.food12, "Oyster On Ice",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.mipmap.food13, "Fried Rice on Pot",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.mipmap.food11, "Oyster Dish",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.mipmap.food12, "Oyster On Ice",
                "Shortbread, chocolate turtle cookies, and red velvet."
            ),
            SingleRestaurant(
                R.mipmap.food13, "Fried Rice on Pot",
                "Shortbread, chocolate turtle cookies, and red velvet."
            )
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSingleRestaurantTabBinding.bind(view)

        binding.rvTabSingleRestaurant.adapter = singleRestaurantAdapter1
        binding.rvTabSingleRestaurant.isNestedScrollingEnabled = false
        binding.rvTabSingleRestaurant.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

        binding.rvTabSingleRestaurant1.adapter = singleRestaurantAdapter2
        binding.rvTabSingleRestaurant1.isNestedScrollingEnabled = false
        binding.rvTabSingleRestaurant1.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

    }
}