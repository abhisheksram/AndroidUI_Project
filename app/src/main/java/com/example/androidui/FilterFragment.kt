package com.example.androidui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.androidui.databinding.FragmentFilterBinding
import com.example.androidui.util.showToast

class FilterFragment : Fragment(R.layout.fragment_filter) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFilterBinding.bind(view)

        binding.tvClearAll.setOnClickListener {
            binding.chipCategories.clearCheck()
        }
        binding.tvClearAllDietary.setOnClickListener {
            binding.chipDietary.clearCheck()
        }
        binding.tvClearAllPrice.setOnClickListener {
            binding.chipPriceRange.clearCheck()
        }

        binding.btnApplyFilters.setOnClickListener {
            this.context?.showToast("Filters are Applied")

            requireActivity().onBackPressed()
        }

    }

}