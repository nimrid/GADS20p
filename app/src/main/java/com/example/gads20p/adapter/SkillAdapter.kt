package com.example.gads20p.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gads20p.R
import com.example.gads20p.model.SkillIQItem
import kotlinx.android.synthetic.main.item_list.view.*

class SkillAdapter(var skillIQ: ArrayList<SkillIQItem?>, private val context: Context) :
    RecyclerView.Adapter<SkillAdapter.SkillViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        return SkillViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_list, parent, false
        ))
    }

    override fun getItemCount(): Int = skillIQ.size

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        var skill = skillIQ[position]
        holder.itemView.name.text = skill!!.name
        holder.itemView.record.text = "${skill.score} skill IQ Score, ${skill.country}"
        Glide.with(context).load(skill.badgeUrl).into(holder.itemView.badge_image)

    }

    class SkillViewHolder(view : View) : RecyclerView.ViewHolder(view)
}