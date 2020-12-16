package com.example.cryptocurrency.RecyClerView

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.Model.currency
import com.example.cryptocurrency.R
import kotlinx.android.synthetic.main.cardviewcurrency.view.*
import kotlin.math.hypot

class currencyAdapter(val dataset:ArrayList<currency>) :
    RecyclerView.Adapter<currencyAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val Code: TextView
        val Currency: TextView
        val Sell: TextView
        val Buy: TextView
        init {
            Code = view.findViewById(R.id.Codecurrency)
            Currency = view.findViewById(R.id.Currencycurrency)
            Sell = view.findViewById(R.id.Sellcurrency)
            Buy = view.findViewById(R.id.Buycurrency)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardviewcurrency , parent ,false )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Currency.text = dataset.get(position).Currency
        holder.Code.text = dataset.get(position).Code
        holder.Buy.text = dataset.get(position).Buy
        holder.Sell.text = dataset.get(position).Sell
        holder.itemView.setOnClickListener{
            Log.d("ClickRecyClerView" , "Currency Items: ${dataset.get(position).Code} ${dataset.get(position).Currency} ${dataset.get(position).Sell} ${dataset.get(position).Buy}}" )
        }
    }

    override fun getItemCount(): Int {
        return dataset.size

    }


}