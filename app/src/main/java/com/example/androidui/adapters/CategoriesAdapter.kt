package com.example.androidui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.data.Categories

class CategoriesAdapter (private val categories: List<Categories>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoryVH>() {

    inner class CategoryVH (view: View) : RecyclerView.ViewHolder(view){

        private val imageView = view.findViewById<ImageView>(R.id.imageRVCategories)
        private val categoryName = view.findViewById<TextView>(R.id.tvRVCategories)

        fun bind(categories: Categories){
            imageView.setImageResource(categories.categoryImage)
            categoryName.text = categories.categoryName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.CategoryVH {
        return CategoryVH(LayoutInflater.from(parent.context).inflate(R.layout.item_categories,parent,false))
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.CategoryVH, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}