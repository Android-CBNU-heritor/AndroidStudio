package com.example.opensource_project;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.opensource_project.registration.registrationService;

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


        // -- Detailed menu1 - Pizza --
        ImageButton detailedMenu1 = (ImageButton) findViewById(R.id.imageButton1);
        detailedMenu1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DetailedMenu1.class);
                startActivity(intent);
            }
        });

        // -- Detailed menu4 - Chicken --
        ImageButton detailedMenu4 = (ImageButton) findViewById(R.id.imageButton4);
        detailedMenu4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DetailedMenu4.class);
                startActivity(intent);
            }
        });

        // 등록 업체가 없음을 알림
        ImageButton detailedMenu2 = (ImageButton) findViewById(R.id.imageButton2);
        detailedMenu2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "모든 업체가 금일 영업을 종료했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton detailedMenu3 = (ImageButton) findViewById(R.id.imageButton3);
        detailedMenu3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "등록된 업체가 없습니다.", Toast.LENGTH_SHORT).show();
            }
        });







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