package com.example.opensource_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class DetailedMenu1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_menu1);

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
        // yet!!! 코드 최적화 안함
        else if(auth == 3){ // 외부 사용자
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
