package com.example.cryptocurrency

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cryptocurrency.Model.Gold
import com.example.cryptocurrency.Model.Item
import com.example.cryptocurrency.Model.currency
import org.json.JSONArray
import org.json.JSONObject

class currencyClass {

    private var TAG = "TAGJSON"
    private lateinit var context: Context

    constructor(context: Context) {
        this.context = context
    }

    fun connectToApi() {
        try {


            var queue = Volley.newRequestQueue(context)

            var URL = "https://currency.jafari.li/json"

            var stringRequest = StringRequest(Request.Method.GET, URL, { Res ->



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
        for (i in 0..currencyArray.length() - 1) {
            var currency: currency
            var Code = currencyArray.getJSONObject(i).getString("Code")
            var Currency = currencyArray.getJSONObject(i).getString("Currency")
            var Sell = currencyArray.getJSONObject(i).getString("Sell")
            var Buy = currencyArray.getJSONObject(i).getString("Buy")
            currency = currency(Code, Currency, Sell, Buy)
            Log.d(
                TAG,
                "Code: ${currency.Code} , Currency: ${currency.Currency} , Buy: ${currency.Buy} , Sell: ${currency.Sell}"
            )
        }
    }

    //fun recive Item price
    private fun Item(ItemArray: JSONArray) {
        for (i in 0..ItemArray.length() - 1) {
            var Item: Item
            var name: String = ItemArray.getJSONObject(i).optString("Name")
            var Rate: String = ItemArray.getJSONObject(i).optString("Rate")
            Item = Item(name, Rate)
            Log.d(
                TAG,
                "Name: ${Item.Name} , Rate: ${Item.Rate}"
            )
        }
    }

    //fun recive Gold price
    private fun Gold(GoldArray: JSONArray) {

        for (i in 0..GoldArray.length() - 1) {
            var Gold: Gold
            var Coin = GoldArray.getJSONObject(i).optString("Coin")
            var Sell = GoldArray.getJSONObject(i).optString("Sell")
            var Buy = GoldArray.getJSONObject(i).optString("Buy")
            Gold = Gold(Coin, Sell, Buy)
            Log.d(TAG, "Coin:${Gold.Coin}  ,Sell: ${Gold.Sell} , Buy:${Gold.Buy} ")
        }
    }

}