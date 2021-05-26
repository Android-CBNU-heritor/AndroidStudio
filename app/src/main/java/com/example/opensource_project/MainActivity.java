package com.example.opensource_project;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {
    //Initialize variable
    ViewPager2 vpHorizontal;
    LinearLayout layoutIndicator;

    int[] images = {R.drawable.fish,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4};
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Assign variable
        vpHorizontal = findViewById(R.id.vp_horizontal);

        //Initialize main adapter
        adapter = new MainAdapter(images);


        //Set adapter on horizontal viewpager
        //vpHorizontal.setAdapter(adapter);
        //Set clip padding
        vpHorizontal.setClipToPadding(false);
        //Set clip children
        vpHorizontal.setClipChildren(false);
        //Set clip limit
        vpHorizontal.setOffscreenPageLimit(3);
        //Set default start position
        vpHorizontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //Set adapter on horizontal viewpager
        vpHorizontal.setAdapter(adapter);

        //Initialize composite page transformer
        CompositePageTransformer transformer = new CompositePageTransformer();
        //Add margin between page
        transformer.addTransformer(new MarginPageTransformer(10));
        //Increase selected page size
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float v = 3 - Math.abs(position);
                //Set scale y
                page.setScaleY(0.5f + v * 0.2f);
            }
        });
        //Set page transform
        vpHorizontal.setPageTransformer(transformer);
    }
}