package com.example.androidui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidui.R
import com.example.androidui.adapters.FeaturedPartnerAdapter
import com.example.androidui.common.Constants
import com.example.androidui.data.Partners
import kotlinx.android.synthetic.main.fragment_burgers.*


class BurgersFragment : Fragment(R.layout.fragment_burgers) {

    private var partnerAdapter = FeaturedPartnerAdapter(
        listOf(
            Partners(R.mipmap.burger01, "McDonald's"),
            Partners(R.mipmap.burger02, "Tacos Nanchas"),
            Partners(R.mipmap.burger03, "McDonald's"),
            Partners(R.mipmap.burger04, "McDonald's"),
            Partners(R.mipmap.burger01, "McDonald's"),
            Partners(R.mipmap.burger02, "Tacos Nanchas"),
            Partners(R.mipmap.burger03, "McDonald's"),
            Partners(R.mipmap.burger04, "McDonald's"),
            Partners(R.mipmap.burger01, "McDonald's"),
            Partners(R.mipmap.burger02, "Tacos Nanchas"),
            Partners(R.mipmap.burger03, "McDonald's"),
            Partners(R.mipmap.burger04, "McDonald's")
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val args = this.arguments
        val title = args?.getString(Constants.Prefs.title)

        if (title == null){
            tvCount.text = "We have founds ${partnerAdapter.itemCount} results for your search"
        } else {
            tvCount.text = "We have founds ${partnerAdapter.itemCount} results for $title"
        }

        rvBurgers.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        )

        rvBurgers.adapter = partnerAdapter

        tvSearchAgain.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_burgersFragment2_to_searchItemsFragment2)

        }

    }
}