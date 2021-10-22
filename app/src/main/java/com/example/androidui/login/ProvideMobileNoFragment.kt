package com.example.androidui.login

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.androidui.R
import com.example.androidui.common.Constants
import com.example.androidui.databinding.FragmentProvideMobileNoBinding
import com.example.androidui.util.showToast


class ProvideMobileNoFragment : Fragment(R.layout.fragment_provide_mobile_no) {


    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentProvideMobileNoBinding.bind(view)

        binding.ccp.setDefaultCountryUsingNameCode("IND")

        binding.btnMobileSignUp.setOnClickListener {

            if(binding.etPhoneNumber.text.isNullOrEmpty()){
                this.context?.showToast("Provide Phone number")
            } else
                if (binding.etPhoneNumber.text!!.length!=10){
                    this.context?.showToast("Phone number invalid")
                }

            else {
                val bundle = Bundle()
                bundle.putString(
                    Constants.Bundles.phone,
                    "+${binding.ccp.selectedCountryCode} ${binding.etPhoneNumber.text}"
                )

                val navController: NavController = Navigation.findNavController(view)
                navController.navigate(
                    R.id.action_provideMobileNoFragment2_to_verifyMobileNoFragment2,
                    bundle
                )
            }
        }
    }
}