package com.example.androidui.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.common.Constants
import com.example.androidui.data.AllRestaurants

class AllRestaurantsAdapter (private val allRestaurants:  List<AllRestaurants>) :
    RecyclerView.Adapter<AllRestaurantsAdapter.RestaurantsVH>() {

    inner class RestaurantsVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.image_all_restaurants)
        private val itemsName = view.findViewById<TextView>(R.id.tv_all_restaurants)

        init {
            with(view){
                view.setOnClickListener {

                    val bundle = Bundle()
                    bundle.putInt(Constants.Prefs.image, allRestaurants[adapterPosition].allRestaurantsImage)
                    bundle.putString(Constants.Prefs.title,allRestaurants[adapterPosition].allRestaurantsName)
                    val navController: NavController = Navigation.findNavController(view)
                    navController.navigate(R.id.action_allRestaurantFragment_to_singleRestaurantFragment,bundle)
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