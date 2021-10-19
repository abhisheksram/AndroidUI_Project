package com.example.androidui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.data.BestPartners

class PartnersAdapter(private val partners:  List<BestPartners>) :
    RecyclerView.Adapter<PartnersAdapter.PartnersVH>() {

    inner class PartnersVH(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.image_RV_home_partners)
        private val itemsName = view.findViewById<TextView>(R.id.tv_RV_home_itemsName)
        private val itemsLocation = view.findViewById<TextView>(R.id.tv_RV_home_itemsLocation)

        fun bind(partners: BestPartners) {
            imageView.setImageResource(partners.bestPartnersImage)
            itemsName.text = partners.bestPartnersName
            itemsLocation.text = partners.bestPartnersLocation
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartnersVH {
        return PartnersVH(LayoutInflater.from(parent.context).inflate(R.layout.item_home_partners,parent,false))
    }

    override fun onBindViewHolder(holder: PartnersVH, position: Int) {
        holder.bind(partners[position])
    }

    override fun getItemCount(): Int {
        return partners.size
    }
}