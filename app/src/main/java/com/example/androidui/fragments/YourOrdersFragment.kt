package com.example.androidui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidui.R
import com.example.androidui.adapters.YourOrderAdapter
import com.example.androidui.data.Orders
import com.example.androidui.util.showToast
import kotlinx.android.synthetic.main.fragment_your_orders.*


class YourOrdersFragment : Fragment(R.layout.fragment_your_orders) {

    private val ordersAdapter = YourOrderAdapter(
        listOf(
            Orders(1,"Cookie Sandwich",
                "Shortbread, chocolate turtle cookies, and red velvet.","AUD\$10"),
            Orders(2,"Combo Burger",
                "Shortbread, chocolate turtle cookies, and red velvet.","AUD\$10"),
            Orders(3,"Oyster Dish",
                "Shortbread, chocolate turtle cookies, and red velvet.","AUD\$10")
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        rvYourOrders.adapter = ordersAdapter
        rvYourOrders.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)

        btnConfirmOrder.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_yourOrdersFragment_to_paymentFragment)
        }

        btnPromoCode.setOnClickListener {
            this.context?.showToast("Currently this option is not available")
        }

        btnAddMoreItems.setOnClickListener {
            this.context?.showToast("Currently this option is not available")
        }


    }
}