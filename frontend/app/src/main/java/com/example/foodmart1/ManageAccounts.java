package com.example.foodmart1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodmart1.Controller.StoreController;

public class ManageAccounts extends AppCompatActivity {

    StoreController storeController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_accounts);
        storeController = StoreController.getInstance();
    }

    public void changePassword(View v) {

    }

    public void changeUsername(View v) {

    }

    public void changeBaseUrl(View v) {
        EditText url = findViewById(R.id.edit_text_BaseUrl);
        StoreController.getInstance().BaseUrl = url.getText().toString();
        Toast.makeText(getApplicationContext(), "http://" + StoreController.getInstance().BaseUrl + ":" + StoreController.getInstance().Port, Toast.LENGTH_SHORT).show();
        url.setText("");
    }

    public void changePort(View v) {
        EditText port = findViewById(R.id.edit_text_port);
        StoreController.getInstance().Port = port.getText().toString();
        Toast.makeText(getApplicationContext(), "http://" + StoreController.getInstance().BaseUrl + ":" + StoreController.getInstance().Port, Toast.LENGTH_SHORT).show();
        port.setText("");
    }

}
