package com.example.cryptocurrency

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(object :Runnable{
            override fun run() {
                val intent = Intent(applicationContext, guidePage::class.java)
                startActivity(intent)


            }

        } , 5000)
        }
}