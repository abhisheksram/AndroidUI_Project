package com.example.androidui.adapters

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.home.RestaurantActivity
import com.example.androidui.common.Constants
import com.example.androidui.data.AllRestaurants

class AllRestaurantsAdapter (private val allRestaurants:  List<AllRestaurants>) :
    RecyclerView.Adapter<AllRestaurantsAdapter.RestaurantsVH>() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    inner class RestaurantsVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.image_all_restaurants)
        private val itemsName = view.findViewById<TextView>(R.id.tv_all_restaurants)

        init {
            with(view){
                view.setOnClickListener {

                    sharedPreferences =
                        this.context.getSharedPreferences(Constants.Prefs.image, Context.MODE_PRIVATE)

                    editor = sharedPreferences.edit()

                    editor.apply{
                        putInt("image", allRestaurants[adapterPosition].allRestaurantsImage)
                        putString("title", allRestaurants[adapterPosition].allRestaurantsName)
                    }.apply()

                    val intent = Intent(this.context, RestaurantActivity::class.java)
                    this.context.startActivity(intent)

                }
            }
        }

        fun bind(allRestaurants: AllRestaurants) {
            imageView.setImageResource(allRestaurants.allRestaurantsImage)
            itemsName.text = allRestaurants.allRestaurantsName

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsVH {
        return RestaurantsVH(LayoutInflater.from(parent.context).inflate(R.layout.item_all_restaurants,parent,false))
    }

    override fun onBindViewHolder(holder: RestaurantsVH, position: Int) {
        holder.bind(allRestaurants[position])
    }

    override fun getItemCount(): Int {
        return allRestaurants.size
    }
}