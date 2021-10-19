package com.example.androidui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidui.R
import com.example.androidui.data.Orders

class YourOrderAdapter(private val orders: List<Orders>) :
    RecyclerView.Adapter<YourOrderAdapter.OrdersVH>() {

    inner class OrdersVH (view: View) : RecyclerView.ViewHolder(view){

        private val orderIndex = view.findViewById<TextView>(R.id.tvOrderIndex)
        private val orderItemName = view.findViewById<TextView>(R.id.tvOrderItemName)
        private val orderItemDesc = view.findViewById<TextView>(R.id.tvOrderItemDesc)
        private val orderItemCost = view.findViewById<TextView>(R.id.tvOrderItemCost)


        fun bind(orders: Orders){

            orderIndex.text = orders.orderIndex.toString()
            orderItemName.text = orders.orderItemName
            orderItemDesc.text = orders.orderItemDesc
            orderItemCost.text = orders.orderItemCost
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourOrderAdapter.OrdersVH {
        return OrdersVH(LayoutInflater.from(parent.context).inflate(R.layout.item_your_orders,parent,false))
    }

    override fun onBindViewHolder(holder: YourOrderAdapter.OrdersVH, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount(): Int {
        return orders.size
    }
}