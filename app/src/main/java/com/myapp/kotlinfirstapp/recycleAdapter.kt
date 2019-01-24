package com.myapp.kotlinfirstapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class recycleAdapter(val items: ArrayList<DataModel>, val context: Context?, val testInterface: TestInterface) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvAnimalType?.text = items.get(position).name
        holder.tvage?.text = items.get(position).age.toString()
        holder.tvAnimalType.setOnClickListener()
        {
            testInterface.clicked(position)
        }
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvAnimalType = view.findViewById<TextView>(R.id.type)
    val tvage = view.findViewById<TextView>(R.id.age)
}