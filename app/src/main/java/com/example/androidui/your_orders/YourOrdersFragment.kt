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
import com.example.androidui.databinding.FragmentYourOrdersBinding
import com.example.androidui.util.showToast


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
        val binding = FragmentYourOrdersBinding.bind(view)

        binding.rvYourOrders.adapter = ordersAdapter
        binding.rvYourOrders.isNestedScrollingEnabled = false
        binding.rvYourOrders.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)

        binding.btnConfirmOrder.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_yourOrdersFragment2_to_paymentFragment2)
        }

        binding.btnPromoCode.setOnClickListener {
            this.context?.showToast("No promo codes are available")
        }

        binding.btnAddMoreItems.setOnClickListener {
            this.context?.showToast("Currently this option is not available")
        }

        val subTotal = ordersAdapter.itemCount * 10
        binding.tvSubtotal.text = "AUD$$subTotal"

        val delivery = 0
        binding.tvTotalDelivery.text = "$$delivery"

        val total = subTotal + delivery
        binding.tvTotalOrder.text ="AUD$$total"
    }
}