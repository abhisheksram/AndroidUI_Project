package com.example.androidui.your_orders

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

        val args = this.arguments
        val title = args?.getString(Constants.Prefs.title)
        val image = args?.getInt(Constants.Prefs.image)

        imageAddToOrder.setImageResource(image!!)
        tvAddToOrderName.text = title

        btnAddToOrder.setOnClickListener {
            val singleNavController: NavController = Navigation.findNavController(view)
            singleNavController.navigate(R.id.action_addToOrderFragment2_to_yourOrdersActivity)
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