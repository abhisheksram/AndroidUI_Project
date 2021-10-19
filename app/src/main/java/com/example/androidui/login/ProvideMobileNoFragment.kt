package com.example.androidui.login

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.androidui.R
import kotlinx.android.synthetic.main.fragment_provide_mobile_no.*
import com.example.androidui.common.Constants
import com.example.androidui.util.showToast


class ProvideMobileNoFragment : Fragment(R.layout.fragment_provide_mobile_no) {


    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ccp.setDefaultCountryUsingNameCode("IND")

        btnMobileSignUp.setOnClickListener {

            if(etPhoneNumber.text.isNullOrEmpty()){
                this.context?.showToast("Provide Phone number")
            } else
                if (etPhoneNumber.text!!.length!=10){
                    this.context?.showToast("Phone number invalid")
                }

            else {
                val bundle = Bundle()
                bundle.putString(
                    Constants.Bundles.phone,
                    "+${ccp.selectedCountryCode} ${etPhoneNumber.text}"
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