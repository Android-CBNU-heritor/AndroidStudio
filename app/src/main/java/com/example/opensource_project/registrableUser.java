package com.example.opensource_project;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class registrableUser extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_registration);



        // id, passwd, name, birth
        Button buttonForRgst = (Button) findViewById(R.id.registration);
        buttonForRgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                anyDatabase anyDatabase1 = new anyDatabase(this);
                SQLiteDatabase database;

                database = anyDatabase1.getWritableDatabase();
                anyDatabase1.onCreate(database);

                EditText idText, nameText, passWdText, birthText;
                birthText = (EditText) findViewById(R.id.editTextdirth);
                idText = (EditText) findViewById(R.id.editTextId);
                nameText = (EditText) findViewById(R.id.editTextName);
                passWdText = (EditText) findViewById(R.id.editTextTextPassword);


                // 왜 배열의 형태로 transform해서 보내는지 이유를
                database.execSQL( "INSERT INTO userGroup(id, passWd, name, birth) VALUES('"
                                + idText.getText().toString() + "' , "
                                + passWdText.getText().toString() + "' , "
                                + nameText.getText().toString() + "' , "
                                + birthText.getText().toString() + ");");
                database.close();
                Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
