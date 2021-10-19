package com.example.androidui.login

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.androidui.R
import com.example.androidui.common.Constants
import com.example.androidui.util.showToast
import kotlinx.android.synthetic.main.fragment_forgot_password.*


class ForgotPasswordFragment : Fragment(R.layout.fragment_forgot_password) {

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnResetPassword.setOnClickListener {

            val email = etEmailID.text.toString()

            if (email.isEmpty()) {

                Toast.makeText(context, "Enter E-mail", Toast.LENGTH_SHORT).show()
            } else
                if (!email.matches(emailPattern.toRegex())) {

                    this.context?.showToast("Invalid email address")

                } else {

                    val bundle = Bundle()
                    bundle.putString(Constants.Bundles.email, email)

                    val navController: NavController = Navigation.findNavController(view)
                    navController.navigate(
                        R.id.action_forgotPasswordFragment2_to_resetEmailFragment2,
                        bundle
                    )
                    navController.backStack
                }


        }
    }
}

