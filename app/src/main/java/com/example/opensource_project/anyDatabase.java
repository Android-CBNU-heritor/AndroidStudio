package com.example.opensource_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class anyDatabase extends SQLiteOpenHelper {

    public anyDatabase(@Nullable View.OnClickListener context) {
        super((Context) context, "Maindb", null, 1);
    }

    // 도메인?
    // id, passwd, name, birth
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE userTable (id TEXT PRIMARY KEY NOT NULL, pwssWd TEXT NOT NULL, name TEXT NOT NULL, birth TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
