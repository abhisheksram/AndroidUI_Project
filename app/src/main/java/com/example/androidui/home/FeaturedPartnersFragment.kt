package com.example.androidui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.adapters.FeaturedPartnerAdapter
import com.example.androidui.data.Partners

class FeaturedPartnersFragment : Fragment(R.layout.fragment_featured_partners) {

    private var partnerAdapter = FeaturedPartnerAdapter(
        listOf(
            Partners(R.mipmap.partner1, "Tacos Nanchas"),
            Partners(R.mipmap.partner2, "McDonald's"),
            Partners(R.mipmap.partner3, "KFC Foods"),
            Partners(R.mipmap.partner4, "Cafe MayField’s"),
            Partners(R.mipmap.partner5, "McDonald's"),
            Partners(R.mipmap.partner6, "McDonald's"),
            Partners(R.mipmap.partner1, "Tacos Nanchas"),
            Partners(R.mipmap.partner2, "McDonald's"),
            Partners(R.mipmap.partner3, "KFC Foods"),
            Partners(R.mipmap.partner4, "Cafe MayField’s"),
            Partners(R.mipmap.partner5, "McDonald's"),
            Partners(R.mipmap.partner6, "McDonald's")
        )
    )

    lateinit var recyclerView : RecyclerView
    private lateinit var gridLayoutManager : GridLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView  = view.findViewById(R.id.rvFeaturedPartners)
        gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = partnerAdapter
        recyclerView.layoutManager = gridLayoutManager

    }

}