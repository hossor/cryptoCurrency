package com.example.cryptocurrency

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(object :Runnable{
            override fun run() {
                val sharedPref = getSharedPreferences("guidepage" , Context.MODE_PRIVATE)
                var i: Boolean? = sharedPref.getBoolean("firstTime",true)

                if (i==true){
                    var editor = sharedPref.edit()
                    editor.putBoolean("firstTime",false)
                    editor.commit()
                    val intent = Intent(applicationContext, guidePage::class.java)
                    startActivity(intent)
                    finish()

                }
                else{
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                }



            }

        } , 5000)
        }
}