package com.example.cryptocurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Hello" , "Hello world")
		Log.d("Hello,mmd" , "Hello my name is mmd")
        Log.d("Hello,Hossor" , "Hello my name is Hossor")


    }
}