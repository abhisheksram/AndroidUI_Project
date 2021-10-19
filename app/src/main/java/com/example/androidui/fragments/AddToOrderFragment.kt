package com.example.androidui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.androidui.R
import com.example.androidui.common.Constants
import com.example.androidui.util.showToast
import kotlinx.android.synthetic.main.fragment_add_to_order.*


class AddToOrderFragment : Fragment(R.layout.fragment_add_to_order) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


        val args = this.arguments
        val title = args?.getString(Constants.Prefs.title)
        val image = args?.getInt(Constants.Prefs.image)

        imageAddToOrder.setImageResource(image!!)
        tvAddToOrderName.text = title


        btnAddToOrder.setOnClickListener {
            requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_addToOrderFragment_to_yourOrdersFragment)
        }

        btnAddSpecialInstructions.setOnClickListener {
            this.context?.showToast("Currently this option is not available")
        }

        var count = 0
        if (count < 10) {
            tvAddToOrderCount.text = "0$count"
        } else {
            tvAddToOrderCount.text = "$count"
        }
        btnAddtoOrderPlus.setOnClickListener {
            count += 1
            if (count < 10) {
                tvAddToOrderCount.text = "0$count"
            } else {
                tvAddToOrderCount.text = "$count"
            }
        }

        btnAddToOrderMinus.setOnClickListener {
            count -= 1
            if (count > 0) {
                if (count < 10) {
                    tvAddToOrderCount.text = "0$count"
                } else {
                    tvAddToOrderCount.text = "$count"
                }
            } else {
                count = 0
                if (count < 10) {
                    tvAddToOrderCount.text = "0$count"
                } else {
                    tvAddToOrderCount.text = "$count"
                }
            }
        }

    }


}