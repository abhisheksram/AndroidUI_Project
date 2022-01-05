package com.example.androidui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.androidui.R
import com.example.androidui.adapters.BestRestaurantsAdapter
import com.example.androidui.adapters.HomeRestaurantsAdapter
import com.example.androidui.adapters.HomeViewPagerAdapter
import com.example.androidui.adapters.PartnersAdapter
import com.example.androidui.common.Constants
import com.example.androidui.data.*
import com.example.androidui.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private var pagerAdapter = HomeViewPagerAdapter(
        listOf(
            ImageList(R.mipmap.home_image),
            ImageList(R.mipmap.home_image),
            ImageList(R.mipmap.home_image),
            ImageList(R.mipmap.home_image),
            ImageList(R.mipmap.home_image)
        )
    )

    private var partnersAdapter = PartnersAdapter(
        listOf(
            BestPartners(
                R.mipmap.bestpartner1, "Krispy Creme",
                "St Georgece Terrace, Perth"
            ),
            BestPartners(
                R.mipmap.bestpartner2, "Mario Italiano",
                "Hay street , Perth City"
            ),
            BestPartners(
                R.mipmap.bestpartner1, "Krispy Creme",
                "St Georgece Terrace, Perth"
            ),
            BestPartners(
                R.mipmap.bestpartner2, "Mario Italiano",
                "Hay street , Perth City"
            ),
            BestPartners(
                R.mipmap.bestpartner1, "Krispy Creme",
                "St Georgece Terrace, Perth"
            ),
            BestPartners(
                R.mipmap.bestpartner2, "Mario Italiano",
                "Hay street , Perth City"
            )
        )
    )

    private var bestRestaurantsAdapter = BestRestaurantsAdapter(
        listOf(
            BestRestaurants(
                R.mipmap.best_retaurants1, "McDonald’s",
                "Hay street , Perth City"
            ),
            BestRestaurants(
                R.mipmap.best_retaurants2, "The Halal Guys",
                "Hay street , Perth City"
            ),
            BestRestaurants(
                R.mipmap.best_retaurants1, "McDonald’s",
                "Hay street , Perth City"
            ),
            BestRestaurants(
                R.mipmap.best_retaurants2, "The Halal Guys",
                "Hay street , Perth City"
            ),
            BestRestaurants(
                R.mipmap.best_retaurants1, "McDonald’s",
                "Hay street , Perth City"
            ),
            BestRestaurants(
                R.mipmap.best_retaurants2, "The Halal Guys",
                "Hay street , Perth City"
            )
        )
    )


    private var allRestaurantsAdapter = HomeRestaurantsAdapter(
        listOf(
            AllRestaurants(R.mipmap.all_restaurants1, "McDonald's"),
            AllRestaurants(R.mipmap.all_restaurants2, "Cafe Brichor’s"),
            AllRestaurants(R.mipmap.all_restaurants3, "Mayfield Bakery & Cafe"),
            AllRestaurants(R.mipmap.all_restaurants1, "McDonald's"),
            AllRestaurants(R.mipmap.all_restaurants2, "Cafe Brichor’s"),
            AllRestaurants(R.mipmap.all_restaurants3, "Mayfield Bakery & Cafe")
        )
    )

    private lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        dotsIndicator()

        binding.viewPagerHome1.adapter = pagerAdapter

        binding.viewPagerHome1.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setDots(position)
            }
        })

        sharedPreferences = this.requireContext()
            .getSharedPreferences(Constants.Location.location, Context.MODE_PRIVATE)

        val location = sharedPreferences.getString("location", null)

        if (location != null) {
            binding.tvDeliveryTo.text = location
        } else {
            binding.tvDeliveryTo.text = R.string.location.toString()
        }

        initRecycler()

        binding.tvHomeFilter.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_home2_to_filterFragment2)
        }

        binding.tvSeeAll1.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_home2_to_featuredPartnersFragment2)
        }

        binding.tvSeeAll2.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_home2_to_topRestaurantFragment2)
        }

        binding.tvSeeAll3.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_home2_to_allRestaurantFragment2)
        }

    }

    private fun initRecycler() {
        binding.rvHome1.adapter = partnersAdapter
        binding.rvHome1.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)

        binding.rvHome2.adapter = bestRestaurantsAdapter
        binding.rvHome2.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false)

        binding.rvHome3.adapter = allRestaurantsAdapter
        binding.rvHome3.isNestedScrollingEnabled = false
        binding.rvHome3.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
    }

    private fun dotsIndicator() {
        val mDots = arrayOfNulls<ImageView>(pagerAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8, 0, 8, 0)

        for (i in mDots.indices) {
            mDots[i] = ImageView(this.context)
            mDots[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator1_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            binding.lytViewPager1Dots.addView(mDots[i])
        }
    }

    fun setDots(index: Int) {
        val childCount = binding.lytViewPager1Dots.childCount
        for (i in 0 until childCount) {
            val imageView = binding.lytViewPager1Dots[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator1_active
                    )
                )
            } else imageView.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.indicator1_inactive
                )
            )
        }
    }

}