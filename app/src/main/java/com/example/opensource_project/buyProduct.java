package com.example.opensource_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class buyProduct extends AppCompatActivity {

    Button btnAdd, btnMinus;
    TextView tvCount, priCount;
    int count = 0;
    int pri_chi = 12500;
    int price = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_product);

        priCount = findViewById(R.id.textView19);
        priCount.setText(price + "");
        tvCount = findViewById(R.id.textView11);
        tvCount.setText(count + "");
        btnAdd = findViewById(R.id.button3);
        btnMinus = findViewById(R.id.button2);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tvCount.setText(count + "");
                price = count * pri_chi;
                priCount.setText(price + "");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                tvCount.setText(count + "");
                price = count * pri_chi;
                priCount.setText(price + "");
            }
        });

    }
}