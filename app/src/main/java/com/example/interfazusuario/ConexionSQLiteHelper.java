package com.example.interfazusuario;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.interfazusuario.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

        public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_PROPIETARIO);
        db.execSQL(Utilidades.CREAR_TABLA_VEHICULO);
        db.execSQL(Utilidades.CREAR_TABLA_CELDA);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS propietario");
        db.execSQL("DROP TABLE IF EXISTS vehiculo");
        db.execSQL("DROP TABLE IF EXISTS celda");
        onCreate(db);
    }
}