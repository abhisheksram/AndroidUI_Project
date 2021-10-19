package com.example.androidui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.androidui.R
import com.example.androidui.util.showToast
import kotlinx.android.synthetic.main.fragment_filter.*

class FilterFragment : Fragment(R.layout.fragment_filter) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvClearAll.setOnClickListener {
            chipCategories.clearCheck()
        }
        tvClearAllDietary.setOnClickListener {
            chipDietary.clearCheck()
        }
        tvClearAllPrice.setOnClickListener {
            chipPriceRange.clearCheck()
        }

        btnApplyFilters.setOnClickListener {
            this.context?.showToast("Filters Applied")

            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_filterFragment_to_navigation_home)
        }

    }

}