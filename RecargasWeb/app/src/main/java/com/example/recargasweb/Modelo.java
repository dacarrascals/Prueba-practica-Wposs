package com.example.recargasweb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Modelo {

    public SQLiteDatabase getConn(Context context){
        ConexionSQLite conn = new ConexionSQLite(context, "bdrecargas", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        return db;

    }

    int insertaUsuario(Context context, UsuariosDTO dto){
        int res=0;
        String sql = "INSERT INTO users (nombresapellidos, identificacion, email, password) VALUES('"+dto.getNombresapellidos()+"', '"+dto.getIdentificacion()+"', '"+dto.getEmail()+"','"+dto.getPassword()+"')";
        SQLiteDatabase db = this.getConn(context);
        try {
            db.execSQL(sql);
            res=1;
        } catch (Exception e) {

        }
        return res;
    }


    int validarlogin (Context context, String email, String password){
        int res=0;
        SQLiteDatabase db = this.getConn(context);
        Cursor cursor = db.rawQuery("SELECT * from users WHERE email=? AND password=?", new String[]{email,password});
        if (cursor.getCount()>0)
            res=1;
        return res;

    }
}
