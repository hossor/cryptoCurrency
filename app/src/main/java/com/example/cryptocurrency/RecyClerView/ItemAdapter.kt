package com.example.cryptocurrency.RecyClerView

import android.service.autofill.Dataset
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.Model.Item
import com.example.cryptocurrency.R
import java.util.jar.Attributes

class ItemAdapter(val dataset: ArrayList<Item>):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Name: TextView
        val Rate: TextView

        init {
            Name = view.findViewById(R.id.NameItem)
            Rate = view.findViewById(R.id.RateItem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardviewitem , parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Name.text = dataset.get(position).Name
        holder.Rate.text = dataset.get(position).Rate
        holder.itemView.setOnClickListener{
            Log.d(
                "TAGA",
                "Gold Items: ${dataset.get(position).Name} ${dataset.get(position).Rate}"
            )
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}