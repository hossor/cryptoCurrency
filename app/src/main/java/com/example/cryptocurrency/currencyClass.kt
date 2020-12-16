package com.example.cryptocurrency

import android.app.Activity
import android.content.Context
import android.text.Layout
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cryptocurrency.Model.Gold
import com.example.cryptocurrency.Model.Item
import com.example.cryptocurrency.Model.currency
import com.example.cryptocurrency.RecyClerView.GoldAdapter
import com.example.cryptocurrency.RecyClerView.ItemAdapter
import com.example.cryptocurrency.RecyClerView.currencyAdapter
//import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class currencyClass :AppCompatActivity{

    private var TAG = "TAGJSON"
    private  var context: Activity
    lateinit var goldAdapter: GoldAdapter
    lateinit var recyGold: RecyclerView
    lateinit var recyCurrency: RecyclerView
    lateinit var recyItem: RecyclerView

    constructor(

        context: Activity,

        recyGold: RecyclerView,
        recyCurrency: RecyclerView,
        recyItem: RecyclerView
    ) {

        this.context = context

        this.recyGold = recyGold
        this.recyCurrency = recyCurrency
        this.recyItem = recyItem
    }


    fun connectToApi() {
        try {



            var queue = Volley.newRequestQueue(context)

            var URL = "https://currency.jafari.li/json"

            var stringRequest = StringRequest(Request.Method.GET, URL, { Res ->

                Log.d("TAGCON", "Coin:  " + context )


                var jsonObj = JSONObject(Res)


                //recieve time from api
                var timeUpdate = jsonObj.optString("LastModified")
                Log.d(TAG, timeUpdate)


                //recive currency from api
                var currencyArray = jsonObj.getJSONArray("Currency")
                currency(currencyArray)

                //recive Item from api
                var ItemArray = jsonObj.getJSONArray("Item")
                Item(ItemArray)

                //recive Gold from api
                var GoldArray = jsonObj.getJSONArray("Gold")
                Gold(GoldArray)


            }, {

            })
            queue.add(stringRequest)
        } catch (ex: Exception) {
            Log.d(TAG, ex.message.toString())
        }
    }

    private fun currency(currencyArray: JSONArray) {
        var currensyList:ArrayList<currency> = ArrayList()

        for (i in 0..currencyArray.length() - 1) {
            var currency: currency
            var Code = currencyArray.getJSONObject(i).getString("Code")
            var Currency = currencyArray.getJSONObject(i).getString("Currency")
            var Sell = currencyArray.getJSONObject(i).getString("Sell")
            var Buy = currencyArray.getJSONObject(i).getString("Buy")
            currency = currency(Code, Currency, Sell, Buy)
        currensyList.add(currency)

            Log.d(
                TAG,
                "Code: ${currency.Code} , Currency: ${currency.Currency} " +
                        ", Buy: ${currency.Buy}" +
                        " , Sell: ${currency.Sell}"
            )
        }


recyCurrency.apply {
    layoutManager = LinearLayoutManager(context.applicationContext)
    adapter = currencyAdapter(currensyList)


}




    }

    //fun recive Item price
    private fun Item(ItemArray: JSONArray) {
        var ItemList :ArrayList<Item> = ArrayList()
        for (i in 0..ItemArray.length() - 1) {
            var Item: Item
            var name: String = ItemArray.getJSONObject(i).optString("Name")
            var Rate: String = ItemArray.getJSONObject(i).optString("Rate")
            Item = Item(name, Rate)

            ItemList.add(Item)
            Log.d(
                TAG,
                "Name: ${Item.Name} , Rate: ${Item.Rate}"
            )
        }
        recyItem.apply {
            layoutManager = LinearLayoutManager(context.applicationContext)
            adapter = ItemAdapter(ItemList)

        }
    }

    //fun recive Gold price
    private fun Gold(GoldArray: JSONArray) {
         var goldList : ArrayList<Gold> = ArrayList()
        goldList.clear()


        for (i in 0..GoldArray.length() - 1) {
            var Coin = GoldArray.getJSONObject(i).optString("Coin")
            var Sell = GoldArray.getJSONObject(i).optString("Sell")
            var Buy = GoldArray.getJSONObject(i).optString("Buy")
            var Gold: Gold = Gold(Coin, Sell, Buy)
            goldList.add(Gold)
            Log.d(TAG, "Coin:${Gold.Coin}  ,Sell: ${Gold.Sell} , Buy:${Gold.Buy} ")
        }
        Log.d("Countt" , "${goldList.size}")
        goldAdapter = GoldAdapter(goldList)

        recyGold.apply {
            layoutManager = LinearLayoutManager(context.applicationContext)
            adapter = goldAdapter
        }


    }

}