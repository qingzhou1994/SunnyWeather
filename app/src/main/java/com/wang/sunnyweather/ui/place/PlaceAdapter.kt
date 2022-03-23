package com.wang.sunnyweather.ui.place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wang.sunnyweather.R
import com.wang.sunnyweather.logic.model.Place

class PlaceAdapter(private val places: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {

    inner class PlaceHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val placeName = itemView.findViewById<TextView>(R.id.placeName)
        val placeAddress = itemView.findViewById<TextView>(R.id.placeAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_place,
            parent, false
        )
        return PlaceHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        val place = places[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.address
    }

    override fun getItemCount() = places.size
}