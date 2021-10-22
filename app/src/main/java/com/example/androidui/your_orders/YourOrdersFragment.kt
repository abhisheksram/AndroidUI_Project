package com.example.androidui.your_orders

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvYourOrders.adapter = ordersAdapter
        rvYourOrders.isNestedScrollingEnabled = false
        rvYourOrders.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)

        btnConfirmOrder.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_yourOrdersFragment2_to_paymentFragment2)
        }

        btnPromoCode.setOnClickListener {
            this.context?.showToast("No promo codes are available")
        }

        btnAddMoreItems.setOnClickListener {
            this.context?.showToast("Currently this option is not available")
        }

        val subTotal = ordersAdapter.itemCount * 10
        tvSubtotal.text = "AUD$$subTotal"

        val delivery = 0
        tvTotalDelivery.text = "$$delivery"

        val total = subTotal + delivery
        tvTotalOrder.text ="AUD$$total"
    }
}