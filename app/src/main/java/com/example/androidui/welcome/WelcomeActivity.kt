package com.example.androidui.welcome

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.androidui.R
import com.example.androidui.common.Constants
import com.example.androidui.databinding.ActivityWelcomeBinding
import com.example.androidui.login.LoginActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    private lateinit var welcomeAdapter: WelcomeAdapter
    private lateinit var sharedPreferences: SharedPreferences
    private val pref_show_welcome = "Welcome"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
            actionBar?.hide()

        sharedPreferences = getSharedPreferences(Constants.SharedPreference.slide, Context.MODE_PRIVATE)

        if(!sharedPreferences.getBoolean(pref_show_welcome,true)){
            startActivity(Intent(applicationContext,LoginActivity::class.java))
            finish()
        }

        welcomeAdapter = WelcomeAdapter(supportFragmentManager, lifecycle)
        dotsIndicator()
        binding.welcomeViewPager.adapter = welcomeAdapter
        binding.welcomeViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setDots(position)
            }
        })

        binding.btnGetStarted.setOnClickListener{
            if (binding.welcomeViewPager.currentItem +1 < welcomeAdapter.itemCount){
                binding.welcomeViewPager.currentItem += 1
            }else {
                startActivity(Intent(applicationContext,LoginActivity::class.java))
                finish()
                val editor = sharedPreferences.edit()
                editor.putBoolean(pref_show_welcome,false).apply()
            }
        }

    }

    private fun dotsIndicator() {
        val mDots = arrayOfNulls<ImageView>(welcomeAdapter.itemCount)
        val layoutParams : LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)

        for(i in mDots.indices){
            mDots[i] = ImageView(applicationContext)
            mDots[i].apply {
                this?.setImageDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.indicator_inactive))
                this?.layoutParams = layoutParams
            }
            binding.lytDots.addView(mDots[i])
        }
    }

    fun setDots(index : Int){
        val childCount = binding.lytDots.childCount
        for (i in 0 until childCount){
            val imageView = binding.lytDots[i] as ImageView
            if (i == index){
                imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.indicator_active))
            }
            else imageView.setImageDrawable(ContextCompat.getDrawable(applicationContext,R.drawable.indicator_inactive))
        }
    }

    inner class WelcomeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {

        private val totalTabs = 4

        override fun getItemCount(): Int {
            return totalTabs
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> WelcomeFragment()

                1 -> IntroFragment1()

                2 -> IntroFragment2()

                else -> IntroFragment3()

            }
        }

    }
}