package com.example.androidui.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.example.androidui.util.showToast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.androidui.R
import com.example.androidui.common.Constants
import kotlinx.android.synthetic.main.fragment_signin.*

class SignInFragment : Fragment(R.layout.fragment_signin) {

    @SuppressLint("RestrictedApi", "SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSignIn.setOnClickListener {

            val pref_signed_in = "Sign_IN"

            val sharedPreferences: SharedPreferences? =
                context?.getSharedPreferences(Constants.SighIn.email, Context.MODE_PRIVATE)

            val email = etSignInEmailID.text.toString()
            val password = etSignInPW.text.toString()

            when {
                email.isEmpty() -> {
                    this.context?.showToast("E-mail Empty")
                }
                password.isEmpty() -> {
                    this.context?.showToast("Password Empty")
                }
                sharedPreferences?.getString("Email$email", "").isNullOrEmpty() -> {
                    tvSignInEmail.setTextColor(
                        ContextCompat.getColor(
                            this.requireContext(),
                            R.color.Red
                        )
                    )
                    tvSignInEmail.text = "Incorrect E-mail"
                }
                sharedPreferences?.getString("Password$password", "").isNullOrEmpty() -> {
                    tvSignInPW.setTextColor(
                        ContextCompat.getColor(
                            this.requireContext(),
                            R.color.Red
                        )
                    )
                    tvSignInPW.text = "Incorrect Password"
                }

                else -> {

                    val editor = sharedPreferences?.edit()
                    editor?.putBoolean(pref_signed_in, true)?.apply()

                    this.context?.showToast("Logged in")

                    val navController: NavController = Navigation.findNavController(view)
                    navController.navigate(R.id.action_signInFragment2_to_locationActivity)

                    (requireActivity() as LoginActivity).finish()

                }
            }
        }

        btnGoToSignUp.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_signInFragment2_to_createAccountFragment2)
        }

        tvForgotPW.setOnClickListener {
            val navController: NavController = Navigation.findNavController(view)
            navController.navigate(R.id.action_signInFragment2_to_forgotPasswordFragment2)
        }

    }
}