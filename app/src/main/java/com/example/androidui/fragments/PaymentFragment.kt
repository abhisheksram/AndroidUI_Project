package com.example.androidui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.androidui.util.showToast
import kotlinx.android.synthetic.main.fragment_payment.*
import com.example.androidui.R
import com.example.androidui.RestaurantActivity
import com.example.androidui.YourOrdersActivity

class PaymentFragment : Fragment(R.layout.fragment_payment) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddCard.setOnClickListener {
            this.context?.showToast("Card Added")

            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_paymentFragment2_to_bottomNavigationActivity)

            requireActivity().finish()

        }
    }
}