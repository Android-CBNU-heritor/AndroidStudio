package com.example.opensource_project.registration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.opensource_project.R;

public class registrationService extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_registration);

        // domain = id, passwd, name, birth... all of these are text type (파일 상 변수이름들)
        // 실제 도메인(유저 입력값) = id, pqsswd, passwdCheck, email address


        // 중복확인 버튼
        Button buttonForDuplication = (Button) findViewById(R.id.checkDuplicate);
        buttonForDuplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag = false;
                String userId, cmp;
                EditText getUserSting;
                createDatabaseController mainDB = new createDatabaseController(getApplicationContext(), "Maindb", null, 1);

                getUserSting = (EditText) findViewById(R.id.editTextId); // 유저 아이디 가져오기
                userId = getUserSting.getText().toString();

                SQLiteDatabase database;                                 // select실행을 위한 선언 및 대입
                database = mainDB.getReadableDatabase();
                mainDB.onCreate(database);

                Cursor cursor;
                cursor = database.rawQuery("SELECT id FROM userTable", null);
                cursor.moveToFirst();
                cmp = cursor.getString(0); // 첫 번째 아이디 획득

                flag = cmp.equals(userId);
                while (cursor.moveToNext()) {
                    cmp = cursor.getString(0);
                    if (cmp.equals(userId)) {
                        Toast.makeText(getApplicationContext(), " 중복된 아이디기 존재합니다.", Toast.LENGTH_LONG).show();
                        flag = true;
                        break;
                    }
                }
                if (!flag) Toast.makeText(getApplicationContext(), " 사용 가능한 아이디입니다!", Toast.LENGTH_SHORT).show();
                else finish();
            }
        });

        // 회원가입 버튼
        Button buttonForRgst = (Button) findViewById(R.id.registration);
        buttonForRgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createDatabaseController mainDB = new createDatabaseController(getApplicationContext(), "Maindb",null, 1);
                SQLiteDatabase database;

                database = mainDB.getWritableDatabase();
                mainDB.onCreate(database);

                EditText idText, nameText, passWdText, birthText;
                birthText = (EditText) findViewById(R.id.editTextdirth);
                idText = (EditText) findViewById(R.id.editTextId);
                nameText = (EditText) findViewById(R.id.editTextName);
                passWdText = (EditText) findViewById(R.id.editTextTextPassword);


                // 다음번엔 조금 더 쉬운 db.insert();를 사용해 보자.
                String query = "INSERT INTO userTable VALUES("
                        + "'" + idText.getText().toString() + "'" + ", "
                        + "'" + passWdText.getText().toString() + "'" + ", "
                        + "'" + nameText.getText().toString() + "'" + ", "
                        + "'" + birthText.getText().toString() + "'" + ");";

                database.execSQL(query);
                database.close();
                Toast.makeText(getApplicationContext(), "회원가입 완료!", Toast.LENGTH_LONG).show();
                finish();
            }
        });


        // 취소 버튼
        Button buttonForCancel = (Button) findViewById(R.id.cancel);
        buttonForCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
