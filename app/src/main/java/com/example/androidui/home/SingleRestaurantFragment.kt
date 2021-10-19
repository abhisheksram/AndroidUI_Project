package com.example.androidui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidui.adapters.FeaturedItemsAdapter
import com.example.androidui.adapters.HomeViewPagerAdapter
import com.example.androidui.data.ImageList
import com.example.androidui.data.Partners
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_single_restaurant.*
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.androidui.R
import com.example.androidui.common.Constants


class SingleRestaurantFragment : Fragment() {

    private lateinit var pagerAdapter : HomeViewPagerAdapter

    private var itemAdapter = FeaturedItemsAdapter(
        listOf(
            Partners(R.mipmap.item1, "Cookie Sandwich"),
            Partners(R.mipmap.item2, "Chow Fun"),
            Partners(R.mipmap.item3, "Dim SUm"),
            Partners(R.mipmap.item1, "Cookie Sandwich"),
            Partners(R.mipmap.item2, "Chow Fun"),
            Partners(R.mipmap.item3, "Dim SUm")
        )
    )

    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_single_restaurant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //(activity as BottomNavigationActivity).supportActionBar!!.hide()

        navController = Navigation.findNavController(view)

        val args = this.arguments
        val title = args?.getString(Constants.Prefs.title)
        val image = args?.getInt(Constants.Prefs.image)

        pagerAdapter = HomeViewPagerAdapter(
            listOf(
                ImageList(image!!),
                ImageList(image),
                ImageList(image),
                ImageList(image)
            )
        )

        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        requireActivity().actionBar?.hide()

        tvSingleRestaurantName.text = title

        rvSingleRestaurant.adapter = itemAdapter
        rvSingleRestaurant.layoutManager = LinearLayoutManager(this.context, RecyclerView.HORIZONTAL,false)

        val bundle = Bundle()
        bundle.putInt(Constants.Prefs.image,image)
        bundle.putString(Constants.Prefs.title,title)

        btnTakeAway.setOnClickListener {
            navController.navigate(R.id.action_singleRestaurantFragment_to_addToOrderFragment,bundle)
        }

        viewPagerSingle.adapter = pagerAdapter
        dotsIndicator()
        viewPagerSingle.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setDots(position)
            }
        })

        relativeLayoutSingleRestaurant.visibility = View.VISIBLE

        val tabAdapter = TabAdapter(requireActivity().supportFragmentManager, lifecycle)
        viewPagerTab.adapter = tabAdapter

        TabLayoutMediator(tabLayoutTab, viewPagerTab) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Beef & Lamb"
                }
                1 -> {
                    tab.text = "Seafood"
                }
                2 -> {
                    tab.text = "Appetizers"
                }
                else -> tab.text = "Dim Sum"
            }
        }.attach()

    }

    inner class TabAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {
        private val totalTabs = 4

        override fun getItemCount(): Int {
            return totalTabs
        }

        override fun createFragment(position: Int): Fragment {
            return  SingleRestaurantTabFragment()
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
            lytViewPagerSingle.addView(mDots[i])
        }
    }

    fun setDots(index: Int) {
        val childCount = lytViewPagerSingle.childCount
        for (i in 0 until childCount) {
            val imageView = lytViewPagerSingle[i] as ImageView
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
