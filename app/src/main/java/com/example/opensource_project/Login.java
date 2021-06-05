package com.example.opensource_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.opensource_project.registration.createDatabaseController;
import com.example.opensource_project.registration.registrationService;

import static android.content.ContentValues.TAG;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final boolean[] login_flag = {false, false}; // 순서대로 ID, PW
        Button loginbutton = (Button) findViewById(R.id.Login);
        Button registButton = (Button) findViewById(R.id.Changeregistration);

        boolean flag = false;

        EditText getUserSting;
        createDatabaseController mainDB = new createDatabaseController(getApplicationContext(), "Maindb", null, 1);

        SQLiteDatabase database;                                 // Sqlite db 연결을 위한 객체
        database = mainDB.getReadableDatabase();                 // Maindb의 데이터 내용을 가져옴
        mainDB.onCreate(database);

        Cursor cursor;
        cursor = database.rawQuery("select * from userTable", null); // **모든 컬럼 접근
        //cursor = database.rawQuery("SELECT id FROM userTable", null); // 컬럼 한 개 접근



        registButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), registrationService.class);
                startActivity(intent);
            }
        });


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // cmp1 == ID column, cmp2 == PW inserted
                String cmp1, cmp2;

                cursor.moveToFirst();
                cmp1 = cursor.getString(0);
                cmp2 = cursor.getString(cursor.getColumnIndex("pw"));

                EditText getUserSting;
                getUserSting = (EditText) findViewById(R.id.idText); // 유저 아이디 입력 가져오기
                String userID = getUserSting.getText().toString();

                getUserSting = (EditText) findViewById(R.id.passwordText); // 유저 비밀번호 입력 가져오기
                String userPW = getUserSting.getText().toString();

                Log.d(TAG, "Inserted ID: " + userID);
                Log.d(TAG, "Inserted PW: " + userPW);

                do{
                    if(cmp1.equals(userID)){
                        login_flag[0] = true;

                        if(cmp2.equals(userPW)){
                            login_flag[1] = true;
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            break;
                        }
                        // 어차피 id는 하나이고, 걸려든 id가 pw와 일치하지 않으면 유효하지 않으므로 break
                        break;
                    }
                }while(cursor.moveToNext());

                if(login_flag[0] == false || login_flag[1] == false){
                    Toast.makeText(getApplicationContext(), "아이디 또는 패스워드가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }


            }
        });

    }
}