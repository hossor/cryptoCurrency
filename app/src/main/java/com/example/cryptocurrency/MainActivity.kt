package com.example.cryptocurrency

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cryptocurrency.Model.Gold
import com.example.cryptocurrency.Model.Item
import com.example.cryptocurrency.Model.currency
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var currencyClass1: currencyClass = currencyClass(
            this,recyclerviewGold , recyclerviewCurrency, recyclerviewItem
        ).apply {
            connectToApi()
        }
    }


}