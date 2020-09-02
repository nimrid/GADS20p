package com.example.gads20p.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gads20p.R
import com.example.gads20p.model.LearningHoursItem
import kotlinx.android.synthetic.main.item_list.view.*

class LearningHrAdapter(var learningHours: ArrayList<LearningHoursItem?>, private val context: Context) :
    RecyclerView.Adapter<LearningHrAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_list, parent, false
        ))
    }

    override fun getItemCount(): Int = learningHours.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hours = learningHours[position]
        holder.itemView.name.text = hours!!.name
        holder.itemView.record.text = "${hours.hours} learning hours, ${hours.country}"
        Glide.with(context).load(hours.badgeUrl).into(holder.itemView.badge_image)
    }


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)

}