package com.example.androidui.search

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidui.R
import com.example.androidui.adapters.FeaturedPartnerAdapter
import com.example.androidui.common.Constants
import com.example.androidui.data.Partners
import com.example.androidui.databinding.FragmentBurgersBinding

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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBurgersBinding.bind(view)

        val args = this.arguments
        val title = args?.getString(Constants.Prefs.title)

        if (title == null){
            binding.tvCount.text = "We have founds ${partnerAdapter.itemCount} results for your search"
            //bottomToolbar.title = "Search Results"
        } else {
            binding.tvCount.text = "We have founds ${partnerAdapter.itemCount} results for $title"
            //bottomToolbar.title = title
        }

        binding.rvBurgers.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL
        )

        binding.rvBurgers.adapter = partnerAdapter

        binding.tvSearchAgain.setOnClickListener {
            activity?.onBackPressed()
        }

    }
}