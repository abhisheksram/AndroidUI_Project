package com.example.androidui.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.androidui.R
import com.example.androidui.common.Constants
import com.example.androidui.databinding.FragmentVerifyMobileNoBinding
import com.example.androidui.util.showToast


class VerifyMobileNoFragment : Fragment(R.layout.fragment_verify_mobile_no) {

    @SuppressLint("SetTextI18n", "RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentVerifyMobileNoBinding.bind(view)

        val args = this.arguments
        val phone = args?.getString(Constants.Bundles.phone)

        binding.tvReceivePhone.text = "Enter the 4-Digit code sent to you at \n $phone"

        binding.etCode1.doOnTextChanged { _, _, _, after ->
            if (after == 1) {
                binding.etCode2.requestFocus()
            }
        }
        binding.etCode2.doOnTextChanged { _, _, _, after ->
            if (after == 1) {
                binding.etCode3.requestFocus()
            }
        }
        binding.etCode3.doOnTextChanged { _, _, _, after ->
            if (after == 1) {
                binding.etCode4.requestFocus()
            }
        }
        binding.etCode4.doOnTextChanged { _, _, _, after ->
            if (after == 1) {
                binding.btnContinue.requestFocus()
            }
        }

        binding.btnContinue.setOnClickListener {

            if (binding.etCode1.text.isNullOrEmpty() || binding.etCode2.text.isNullOrEmpty() ||
                binding.etCode3.text.isNullOrEmpty() || binding.etCode4.text.isNullOrEmpty()
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