package com.example.cryptocurrency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.WindowManager;

public class guidePage extends AppCompatActivity {

    ViewPager viewPager2;
    LinearLayout dot;
    sliderAdapter slider;
    TextView[] dots;
    Button startBtn, nextBtn;
    Animation animation;
    int currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide_page);

        viewPager2 =findViewById(R.id.slider);
        dot =findViewById(R.id.dots);
        startBtn=findViewById(R.id.start_btn);
        nextBtn =findViewById(R.id.next_btn);

        slider =new sliderAdapter(this);
        viewPager2.setAdapter(slider);


        addDots(0);
        viewPager2.addOnPageChangeListener(changeListener);

    }

    public void skip(View view){
       Intent intent =new Intent(this,MainActivity.class);
       startActivity(intent);
       finish();

    }
    public void next(View view){
        viewPager2.setCurrentItem(currentPos+1);

    }

    private void addDots(int position) {
        dots = new TextView[4];
        dot.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextColor(getResources().getColor(R.color.design_default_color_background));
            dots[i].setTextSize(35);

            dot.addView(dots[i]);
        }
        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.button));
        }
    }

        ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addDots(position);
                currentPos = position;
                animation = AnimationUtils.loadAnimation(guidePage.this,R.anim.button_anim);

                if(position==0){
                    startBtn.setVisibility(View.INVISIBLE);
                    nextBtn.setVisibility(View.VISIBLE);

                }
                else if(position==1){
                    startBtn.setVisibility(View.INVISIBLE);
                    nextBtn.setVisibility(View.VISIBLE);

                }
                else if(position==2){
                    startBtn.setVisibility(View.INVISIBLE);
                    nextBtn.setVisibility(View.VISIBLE);

                }
                else{

                    startBtn.setAnimation(animation);
                    startBtn.setVisibility(View.VISIBLE);
                    nextBtn.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };



}