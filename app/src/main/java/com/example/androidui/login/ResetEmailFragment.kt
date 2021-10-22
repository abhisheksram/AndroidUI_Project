package com.example.androidui.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.androidui.R
import com.example.androidui.common.Constants
import com.example.androidui.databinding.FragmentResetEmailBinding
import com.example.androidui.util.showToast


class ResetEmailFragment : Fragment(R.layout.fragment_reset_email) {


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentResetEmailBinding.bind(view)

        val args = this.arguments
        val resetEmail = args?.getString(Constants.Bundles.email)
        val receivedEmail = "We have sent a instructions email to. $resetEmail"
        binding.sendEmailText.text = receivedEmail

        binding.btnSendEmail.setOnClickListener {
            this.context?.showToast("Resent E-mail")
        }

        binding.tvHavingProblem.setOnClickListener {
            this.context?.showToast("Help Page is Not available Now")
        }
    }

}