package com.example.opensource_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class DetailedMenu4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_menu4);

        Intent intent = getIntent();
        int auth = intent.getExtras().getInt("auth");
        Button generate_button = (Button) findViewById(R.id.generate_button);
        if(auth == 0){ // 관리자
            Log.d(TAG, "Inserted auth: " + auth);
            generate_button.setVisibility(View.VISIBLE);
        }
        else if(auth == 1){ // 일반 사용자
            Log.d(TAG, "Inserted auth: " + auth);
            generate_button.setVisibility(View.GONE);
        }

        generate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterProduct.class);
                startActivity(intent);
            }
        });

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
