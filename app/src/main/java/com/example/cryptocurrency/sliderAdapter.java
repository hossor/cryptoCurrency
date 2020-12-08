package com.example.cryptocurrency;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.cryptocurrency.R;

public class sliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public sliderAdapter(Context context) {
        this.context = context;
    }

    int image[] = {

            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d
    };

    int headings[] ={
            R.string.graph_he,
            R.string.currancy_he,
            R.string.gold_he,
            R.string.crypto_cr_he
    };
    int descriptions[] ={
            R.string.graph_des,
            R.string.currancy_des,
            R.string.gold_des,
            R.string.crypto_cr_des
    };


    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout,container,false);

        ImageView imageView = view.findViewById(R.id.slide_im);
        TextView heading = view.findViewById(R.id.slide_heading);
        TextView description = view.findViewById(R.id.slide_descreption);

        imageView.setImageResource(image[position]);
        heading.setText(headings[position]);
        description.setText(descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
