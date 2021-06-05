package com.example.opensource_project.registration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import static android.content.ContentValues.TAG;



import com.example.opensource_project.R;
import com.example.opensource_project.registration.createDatabaseController;

public class registrationService extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avtivity_registration);

        // domain = id, passwd, name, birth... all of these are text type (파일 상 변수이름들)
        // 실제 도메인(유저 입력값) = id, pqsswd, passwdCheck, email address

        // 회원가입 버튼을 동작하게 하는 flag
        boolean signUpIsOk = false;

        // 중복확인 버튼
        Button buttonForDuplication = (Button) findViewById(R.id.checkDuplicate);
        buttonForDuplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag = false;
                String userId, cmp;
                EditText getUserSting;
                createDatabaseController mainDB = new createDatabaseController(getApplicationContext(), "Maindb", null, 1);

                getUserSting = (EditText) findViewById(R.id.editTextId); // 유저 아이디 입력 --> 가져오기
                userId = getUserSting.getText().toString();              // String으로 뽑아내기

                SQLiteDatabase database;                                 // Sqlite db 연결을 위한 객체
                database = mainDB.getReadableDatabase();                 // Maindb의 데이터 내용을 가져옴
                mainDB.onCreate(database);

                Cursor cursor;
                cursor = database.rawQuery("SELECT id FROM userTable", null);
                cursor.moveToFirst();
                cmp = cursor.getString(0); // 에러 유발 코드

                flag = cmp.equals(userId);
                Log.d(TAG, "첫번쨰 커서가 가리키는 값?: "+ cursor.getString(0));
                while (cursor.moveToNext()) {

                    Log.d(TAG, "Insert Data: " + userId);
                    Log.d(TAG, "Comparing ID: " + cmp);

                    if (cmp.equals(userId)) {
                        Toast.makeText(getApplicationContext(), " 중복된 아이디가 존재합니다.", Toast.LENGTH_LONG).show();
                        flag = true;
                        break;
                    }

                    cmp = cursor.getString(0);    // 에러 유발 지점1 - 이미 위에서 첫번째 cursor item의 string을 가지고 왔는데, while 조건문이 처음에
                                                     // 실행되면서 cursor가 이동한다. 따라서 두번째부터 비교를 시작하고 중복된 아이디를 찾을 수 없음
                }
                if (!flag) Toast.makeText(getApplicationContext(), " 사용 가능한 아이디입니다!", Toast.LENGTH_SHORT).show();

            }
        });

        // 회원가입 버튼
        Button buttonForRgst = (Button) findViewById(R.id.registration);
        buttonForRgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 중복확인을 정상적으로 진행하지 않았을 때, 회원가입 진행을 막음
                if(signUpIsOk == false){
                    Toast.makeText(getApplicationContext(), "누락된 부분이 있습니다.", Toast.LENGTH_LONG).show();
                };

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