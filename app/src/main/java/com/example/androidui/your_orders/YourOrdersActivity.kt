package com.example.androidui.your_orders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.androidui.R
import com.example.androidui.databinding.ActivityYourOrdersBinding

class YourOrdersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityYourOrdersBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYourOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.navHostYourOrders) as NavHostFragment
        navHost.findNavController().setGraph(R.navigation.nav_your_orders)
        navController = navHost.navController

        setSupportActionBar(binding.yourOrdersToolbar)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()  || super.onSupportNavigateUp()
    }
}