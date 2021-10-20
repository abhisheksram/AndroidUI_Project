package com.example.androidui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.androidui.BottomNavigationActivity
import com.example.androidui.R
import com.example.androidui.adapters.BestRestaurantsAdapter
import com.example.androidui.adapters.HomeRestaurantsAdapter
import com.example.androidui.adapters.HomeViewPagerAdapter
import com.example.androidui.adapters.PartnersAdapter
import com.example.androidui.common.Constants
import com.example.androidui.data.*
import com.example.androidui.util.hide
import com.example.androidui.util.show
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {


    private var pagerAdapter = HomeViewPagerAdapter(
        listOf(
            ImageList(R.mipmap.home_image1),
            ImageList(R.mipmap.home_image1),
            ImageList(R.mipmap.home_image1),
            ImageList(R.mipmap.home_image1),
            ImageList(R.mipmap.home_image1)
        )
    )

    private var partnersAdapter = PartnersAdapter(
        listOf(
            BestPartners(
                R.mipmap.bestpartner1, "Krispy Creme",
                "St Georgece Terrace, Perth"),
            BestPartners(
                R.mipmap.bestpartner2, "Mario Italiano",
                "Hay street , Perth City"),
            BestPartners(
                R.mipmap.bestpartner1, "Krispy Creme",
                "St Georgece Terrace, Perth"),
            BestPartners(
                R.mipmap.bestpartner2, "Mario Italiano",
                "Hay street , Perth City"),
            BestPartners(
                R.mipmap.bestpartner1, "Krispy Creme",
                "St Georgece Terrace, Perth"),
            BestPartners(
                R.mipmap.bestpartner2, "Mario Italiano",
                "Hay street , Perth City")
        )
    )

    private var bestRestaurantsAdapter = BestRestaurantsAdapter(
        listOf(
            BestRestaurants(
                R.mipmap.best_retaurants1, "McDonald’s",
                "Hay street , Perth City"),
            BestRestaurants(
                R.mipmap.best_retaurants2, "The Halal Guys",
                "Hay street , Perth City"),
            BestRestaurants(
                R.mipmap.best_retaurants1, "McDonald’s",
                "Hay street , Perth City"),
            BestRestaurants(
                R.mipmap.best_retaurants2, "The Halal Guys",
                "Hay street , Perth City"),
            BestRestaurants(
                R.mipmap.best_retaurants1, "McDonald’s",
                "Hay street , Perth City"),
            BestRestaurants(
                R.mipmap.best_retaurants2, "The Halal Guys",
                "Hay street , Perth City")
        )
    )


    private var allRestaurantsAdapter = HomeRestaurantsAdapter(
        listOf(
            AllRestaurants(R.mipmap.all_restaurants11, "McDonald's"),
            AllRestaurants(R.mipmap.all_restaurants12, "Cafe Brichor’s"),
            AllRestaurants(R.mipmap.all_restaurants13, "Mayfield Bakery & Cafe"),
            AllRestaurants(R.mipmap.all_restaurants11, "McDonald's"),
            AllRestaurants(R.mipmap.all_restaurants12, "Cafe Brichor’s"),
            AllRestaurants(R.mipmap.all_restaurants13, "Mayfield Bakery & Cafe")
        )
    )

    private lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().actionBar?.hide()
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        (activity as BottomNavigationActivity).bottomToolbar.show()

        dotsIndicator()
        viewPagerHome1.adapter = pagerAdapter
        viewPagerHome1.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setDots(position)
            }
        })

        sharedPreferences =
            this.requireContext().getSharedPreferences(Constants.Location.location, Context.MODE_PRIVATE)

        val location = sharedPreferences.getString("location",null)

        if (location != null) {
            tvDeliveryTo.text = location
        }else
        {
            tvDeliveryTo.text = R.string.location.toString()
        }


        rvHome2.adapter = bestRestaurantsAdapter
        rvHome2.layoutManager = LinearLayoutManager(this.context,RecyclerView.HORIZONTAL,false)

        rvHome1.adapter = partnersAdapter
        rvHome1.layoutManager = LinearLayoutManager(this.context,RecyclerView.HORIZONTAL,false)

        rvHome3.adapter = allRestaurantsAdapter
        rvHome3.isNestedScrollingEnabled = false
        rvHome3.setHasFixedSize(true)
        rvHome3.layoutManager = LinearLayoutManager(this.context,RecyclerView.VERTICAL,false)


        tvHomeFilter.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_home2_to_filterFragment2)
        }

        tvSeeAll1.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_home2_to_featuredPartnersFragment2)
        }

        tvSeeAll2.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_home2_to_topRestaurantFragment2)
        }

        tvSeeAll3.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_navigation_home2_to_allRestaurantFragment2)
        }

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
            lytViewPager1Dots.addView(mDots[i])
        }
    }

    fun setDots(index: Int) {
        val childCount = lytViewPager1Dots.childCount
        for (i in 0 until childCount) {
            val imageView = lytViewPager1Dots[i] as ImageView
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