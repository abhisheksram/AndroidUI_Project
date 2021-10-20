package com.example.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.androidui.common.Constants

class RestaurantActivity : AppCompatActivity() {

    private lateinit var singleNavController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        val navHost = supportFragmentManager.findFragmentById(R.id.navHostSingle) as NavHostFragment
        navHost.findNavController().setGraph(R.navigation.nav_restaurant)
        singleNavController  = navHost.navController

    }
}