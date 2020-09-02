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


/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class LearningLRecyclerViewAdapter(val context: Context) :
    RecyclerView.Adapter<LearningLRecyclerViewAdapter.ViewHolder>() {

  var learnerlist: ArrayList<LearningLeaderModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.learning_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = learnerlist[position]

        holder.llname.text = item.learningleadername
        holder.llhours.text = item.learningleaderhours
        holder.llcountry.text = item.country

        Glide.with(context).load(learnerlist[position].imgurl).into(holder.lllogo)


    }

    override fun getItemCount(): Int = learnerlist.size

    fun setLearnerlist(listoftoplearnears:List<LearningLeaderModel>){
        learnerlist = listoftoplearnears as ArrayList<LearningLeaderModel>;
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val llname: TextView = view.findViewById(R.id.name)
        val llhours: TextView = view.findViewById(R.id.hourstxt)
        val llcountry:TextView = view.findViewById(R.id.countrytxt)
        val lllogo:ImageView = view.findViewById(R.id.logo)


    }



}