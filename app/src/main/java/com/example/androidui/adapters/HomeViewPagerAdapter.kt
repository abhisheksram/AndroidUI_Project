package com.example.androidui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.data.ImageList

class HomeViewPagerAdapter(private val images : List<ImageList>) : RecyclerView.Adapter<HomeViewPagerAdapter.HomeVH>() {
    inner class HomeVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.imageViewHomeViewPager)

        fun bind(images : ImageList){
            imageView.setImageResource(images.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeVH {
        return HomeVH(LayoutInflater.from(parent.context).inflate(R.layout.item_home_viewpager1,parent,false))
    }

    override fun onBindViewHolder(holder: HomeVH, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}