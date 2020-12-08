package com.example.cryptocurrency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class guidePage extends AppCompatActivity {

    ViewPager viewPager2;
    LinearLayout dots;
    sliderAdapter slider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page);

        viewPager2 =findViewById(R.id.slider);
        dots =findViewById(R.id.dots);

        slider =new sliderAdapter(this);
        viewPager2.setAdapter(slider);

    }

}