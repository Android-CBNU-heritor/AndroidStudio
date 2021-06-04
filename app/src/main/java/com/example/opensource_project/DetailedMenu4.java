package com.example.opensource_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DetailedMenu4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_menu4);

        LinearLayout linearButton1 = (LinearLayout) findViewById(R.id.linear1);
        LinearLayout linearButton2 = (LinearLayout) findViewById(R.id.linear2);
        LinearLayout linearButton3 = (LinearLayout) findViewById(R.id.linear3);
        LinearLayout linearButton4 = (LinearLayout) findViewById(R.id.linear4);
        linearButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Payment.class);
                startActivity(intent);
            }
        });
        linearButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(DetailedMenu4.this, "모든 상품이 품절되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        linearButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(DetailedMenu4.this, "모든 상품이 품절되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        linearButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(DetailedMenu4.this, "모든 상품이 품절되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
