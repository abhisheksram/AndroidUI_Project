package com.example.androidui.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.androidui.R
import com.example.androidui.common.Constants
import com.example.androidui.util.showToast
import kotlinx.android.synthetic.main.fragment_verify_mobile_no.*


class VerifyMobileNoFragment : Fragment(R.layout.fragment_verify_mobile_no) {

    @SuppressLint("SetTextI18n", "RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = this.arguments
        val phone = args?.getString(Constants.Bundles.phone)

        val pref_signed_in = "Sign_IN"
        val sharedPreferences: SharedPreferences? =
            context?.getSharedPreferences(Constants.SighIn.email, Context.MODE_PRIVATE)

        tvReceivePhone.text = "Enter the 4-Digit code sent to you at    $phone"

        etCode1.doOnTextChanged { _, _, _, after ->
            if (after == 1) {
                etCode2.requestFocus()
            }
        }
        etCode2.doOnTextChanged { _, _, _, after ->
            if (after == 1) {
                etCode3.requestFocus()
            }
        }
        etCode3.doOnTextChanged { _, _, _, after ->
            if (after == 1) {
                etCode4.requestFocus()
            }
        }
        etCode4.doOnTextChanged { _, _, _, after ->
            if (after == 1) {
                btnContinue.requestFocus()
            }
        }

        btnContinue.setOnClickListener {

            if (etCode1.text.isNullOrEmpty() || etCode2.text.isNullOrEmpty() ||
                etCode3.text.isNullOrEmpty() || etCode4.text.isNullOrEmpty()
            ) {
                this.context?.showToast("Please fill One Time Password to continue")
            } else {
                this.context?.showToast("Successfully registered")

                //val editor = sharedPreferences?.edit()
                //editor?.putBoolean(pref_signed_in, true)?.apply()

                val navController: NavController = Navigation.findNavController(view)
                navController.navigate(R.id.action_verifyMobileNoFragment2_to_signInFragment2)

            }
        }

    }

}