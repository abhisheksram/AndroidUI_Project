package com.example.androidui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.data.BestRestaurants


class BestRestaurantsAdapter (private val bestRestaurants:  List<BestRestaurants>) :
    RecyclerView.Adapter<BestRestaurantsAdapter.RestaurantsVH>() {

    inner class RestaurantsVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.image_RV_home_best_restaurants)
        private val itemsName = view.findViewById<TextView>(R.id.tv_RV_home_best_restaurantsName)
        private val itemsLocation = view.findViewById<TextView>(R.id.tv_RV_home_best_restaurantsLocation)

        fun bind(bestRestaurants:  BestRestaurants) {
            imageView.setImageResource(bestRestaurants.bestRestaurantsImage)
            itemsName.text = bestRestaurants.bestRestaurantsName
            itemsLocation.text = bestRestaurants.bestRestaurantsLocation
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsVH {
        return RestaurantsVH(LayoutInflater.from(parent.context).inflate(R.layout.item_home_best_restaurants,parent,false))
    }

    override fun onBindViewHolder(holder: RestaurantsVH, position: Int) {
        holder.bind(bestRestaurants[position])
    }

    override fun getItemCount(): Int {
        return bestRestaurants.size
    }
}