package com.example.recargasweb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQLite  extends SQLiteOpenHelper {

    final String TBL_USR = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, nombresapellidos TEXT, identificacion TEXT, email TEXT, password TEXT)";



    public ConexionSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TBL_USR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
