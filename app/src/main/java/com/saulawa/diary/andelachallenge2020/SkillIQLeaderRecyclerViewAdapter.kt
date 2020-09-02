package com.saulawa.diary.andelachallenge2020

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.saulawa.diary.andelachallenge2020.models.LearningLeaderModel

import com.saulawa.diary.andelachallenge2020.models.SkillIQLeaderModel

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class SkillIQLeaderRecyclerViewAdapter(val context:Context) :
    RecyclerView.Adapter<SkillIQLeaderRecyclerViewAdapter.ViewHolder>() {

    var skillediqlist: ArrayList<SkillIQLeaderModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.skill_i_q_leaders_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = skillediqlist[position]

        holder.siqname.text = item.skillediqname
        holder.siqscore.text = item.skillediqscore
        holder.siqcountry.text = item.skillediqcountry

        Glide.with(context).load(skillediqlist[position].skillediqimgurl).into(holder.siqlogo)
    }

    override fun getItemCount(): Int = skillediqlist.size

    fun setskillediqlist(skillediqlist:List<SkillIQLeaderModel>){
        this.skillediqlist = skillediqlist as ArrayList<SkillIQLeaderModel>;
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val siqname: TextView = view.findViewById(R.id.siqnametxt)
        val siqscore: TextView = view.findViewById(R.id.siqscoretxt)
        val siqcountry:TextView = view.findViewById(R.id.siqcountrytxt)
        val siqlogo: ImageView = view.findViewById(R.id.siqlogo)


    }
}