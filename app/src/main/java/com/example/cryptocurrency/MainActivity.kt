package com.example.cryptocurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cryptocurrency.Model.Gold
import com.example.cryptocurrency.Model.Item
import com.example.cryptocurrency.Model.currency
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {
    private var TAG = "TAGJSON"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectToApi()

    }

    private fun connectToApi() {
        var queue = Volley.newRequestQueue(this)
        var URL = "https://currency.jafari.li/json"
        var stringRequest = StringRequest(Request.Method.GET, URL, { Res ->
            var jsonObj = JSONObject(Res)


            //recieve time from api
            var timeUpdate = jsonObj.optString("LastModified")
            Log.d("testjson", timeUpdate)
            //

            //recive currency from api
            var currencyArray = jsonObj.getJSONArray("Currency")
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
                //recive Gold from api
                var ItemArray = jsonObj.getJSONArray("Item")
                for (i in 0..ItemArray.length() - 1) {
                    var Item : Item
                    var name:String = ItemArray.getJSONObject(i).optString("Name")
                    var Rate:String = ItemArray.getJSONObject(i).optString("Rate")
                    Item = Item(name , Rate)
                    Log.d(
                        TAG,
                    "Name: ${Item.Name} , Rate: ${Item.Rate}"
                        )

                    //recive Gold from api
                    var GoldArray = jsonObj.getJSONArray("Item")
                    for (i in 0..GoldArray.length()){
                        var Gold:Gold
                        var Coin = GoldArray.getJSONObject(i).getString("Coin")
                        var Sell = GoldArray.getJSONObject(i).getString("Sell")
                        var Buy = GoldArray.getJSONObject(i).getString("Buy")
                        Log.d(TAG , "Coin: ${Coin} ,Sell: ${Sell} , Buy:$Sell ")
                    }

                }


            }
        }, {

        })
        queue.add(stringRequest)
    }
}