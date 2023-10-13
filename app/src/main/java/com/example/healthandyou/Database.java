package com.example.healthandyou;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query1 = "create table users (Username text, email text, password text)";
        sqLiteDatabase.execSQL(query1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Handle database upgrades if needed
    }

    public void register(String username, String email, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);

        db.insert("users", "null", cv);
        db.close();
    }

    public int login(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = password;
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username=? and password=?", str);

        if (cursor.moveToFirst()) {
            result = 1;
        }


        return result;
    }
}

