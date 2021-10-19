package com.example.androidui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.adapters.SearchAdapter
import com.example.androidui.data.SearchList
import kotlinx.android.synthetic.main.fragment_search_items.*

class SearchItemsFragment : Fragment(R.layout.fragment_search_items) {

    private var searchAdapter = SearchAdapter(
        listOf(
            SearchList("Burgers"),SearchList("Subway"),SearchList("Sandwich"),SearchList("Pizza "),
            SearchList("Fried Rice with meat"),SearchList("Bakery"),SearchList("Cake"),SearchList("Cookies")
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchItem.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val navController: NavController = Navigation.findNavController(view)
                navController.navigate(R.id.action_searchItemsFragment_to_burgersFragment)

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                rvSearchItems.adapter = searchAdapter
                rvSearchItems.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false)

                return false
            }


        })

        tvSearchItemClear.setOnClickListener {
            rvSearchItems.adapter = null
        }

        tvSearchItemCancel.setOnClickListener {
            searchItem.setQuery("",false)
            rvSearchItems.adapter = null
        }

    }
}