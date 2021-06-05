package com.example.opensource_project.registration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class createDatabaseController extends SQLiteOpenHelper {


    public createDatabaseController(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // domain = id, passwd, name, birth... all of these are text type
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS userTable (id TEXT PRIMARY KEY NOT NULL, pw TEXT NOT NULL, pwCheck TEXT NOT NULL, email TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
