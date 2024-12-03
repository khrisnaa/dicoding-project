package com.dicoding.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListTourAdapter(private val listTour: ArrayList<Tour>) :
    RecyclerView.Adapter<ListTourAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_card_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_card_name)
        val tvLocation: TextView = itemView.findViewById(R.id.tv_card_location)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_card_price)
        val tvTime: TextView = itemView.findViewById(R.id.tv_card_time)
        val tvRating: TextView = itemView.findViewById(R.id.tv_card_rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.tour_card, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listTour.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, location, price, time, rating, description, photo) = listTour[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvLocation.text = location
        holder.tvPrice.text = price
        holder.tvTime.text = time
        holder.tvRating.text = rating
    }

}