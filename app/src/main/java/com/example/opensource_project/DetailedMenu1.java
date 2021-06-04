package com.example.opensource_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DetailedMenu1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_menu1);


        LinearLayout linearButton1 = (LinearLayout) findViewById(R.id.layout_btn1);
        LinearLayout linearButton2 = (LinearLayout) findViewById(R.id.layout_btn2);
        LinearLayout linearButton3 = (LinearLayout) findViewById(R.id.layout_btn3);
        LinearLayout linearButton4 = (LinearLayout) findViewById(R.id.layout_btn4);
        linearButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Payment2.class);
                startActivity(intent);
            }
        });
        linearButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(DetailedMenu1.this, "상품을 등록 중에 있습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        linearButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(DetailedMenu1.this, "모든 상품이 품절되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        linearButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(DetailedMenu1.this, "모든 상품이 품절되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
