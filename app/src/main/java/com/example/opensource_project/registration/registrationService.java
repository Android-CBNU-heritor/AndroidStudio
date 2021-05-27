package com.example.opensource_project.registration;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.opensource_project.R;
import com.example.opensource_project.registration.createDatabaseController;

public class registrationService extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_registration);



        // id, passwd, name, birth
        Button buttonForRgst = (Button) findViewById(R.id.registration);
        buttonForRgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDatabaseController createDatabaseController1 = new createDatabaseController(getApplicationContext(), "Maindb",null, 1);
                SQLiteDatabase database;

                database = createDatabaseController1.getWritableDatabase();
                createDatabaseController1.onCreate(database);

                EditText idText, nameText, passWdText, birthText;
                birthText = (EditText) findViewById(R.id.editTextdirth);
                idText = (EditText) findViewById(R.id.editTextId);
                nameText = (EditText) findViewById(R.id.editTextName);
                passWdText = (EditText) findViewById(R.id.editTextTextPassword);


                String query = "INSERT INTO userTable VALUES("
                        + "'" + idText.getText().toString() + "'" + ", "
                        + "'" + passWdText.getText().toString() + "'" + ", "
                        + "'" + nameText.getText().toString() + "'" + ", "
                        + "'" + birthText.getText().toString() + "'" + ");";

                // 왜 배열의 형태로 transform해서 보내는지 이유를
                database.execSQL(query);
                database.close();
                Toast.makeText(getApplicationContext(), "회원가입 완료!", Toast.LENGTH_LONG).show();
                finish();
            }
        });


        Button buttonForCancel = (Button) findViewById(R.id.cancel);
        buttonForCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
