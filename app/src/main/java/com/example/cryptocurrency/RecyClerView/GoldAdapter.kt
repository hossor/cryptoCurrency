package com.example.cryptocurrency.RecyClerView

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.Model.Gold
import com.example.cryptocurrency.R

class GoldAdapter(val dataset: ArrayList<Gold>) : RecyclerView.Adapter<GoldAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Code: TextView
        val Currency: TextView
        val Sell: TextView
        val Buy: TextView

        init {
            Code = view.findViewById(R.id.CodeGold)
            Currency = view.findViewById(R.id.CurrencyGold)
            Sell = view.findViewById(R.id.SellGold)
            Buy = view.findViewById(R.id.BuyGold)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardviewgold, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Code.text = dataset.get(position).Coin
        holder.Sell.text = dataset.get(position).Sell
        holder.Buy.text = dataset.get(position).Buy
        holder.itemView.setOnClickListener {
            Log.d(
                "TAGA",
                "Gold Items: ${dataset.get(position).Coin} ${dataset.get(position).Sell} ${
                    dataset.get(position).Buy
                } "
            )
        }
    }

    override fun getItemCount(): Int {
        return dataset.size

    }
}