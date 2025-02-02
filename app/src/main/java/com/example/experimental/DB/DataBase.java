package com.example.experimental.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.experimental.Utilidades.Atributos;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context) {
        super(context, "db_final", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Atributos.CREAR_TABLA_PERSONAS);
        db.execSQL(Atributos.CREAR_TABLA_PROGRAMAS);
        db.execSQL(Atributos.CREAR_TABLA_USUARIOS);
        db.execSQL(Atributos.CREAR_TABLA_CAPACITADOR);
        db.execSQL(Atributos.CREAR_TABLA_CURSOS);
        db.execSQL(Atributos.CREAR_TABLA_PREREQUISITOS);
        db.execSQL(Atributos.CREAR_TABLA_INSCRITOS);
        db.execSQL(Atributos.CREAR_TABLA_ASISTENCIAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS " + Atributos.CREAR_TABLA_ASISTENCIAS);
        db.execSQL("DROP TABLE IF EXISTS " + Atributos.CREAR_TABLA_INSCRITOS);
        db.execSQL("DROP TABLE IF EXISTS " + Atributos.CREAR_TABLA_PREREQUISITOS);
        db.execSQL("DROP TABLE IF EXISTS " + Atributos.CREAR_TABLA_CURSOS);
        db.execSQL("DROP TABLE IF EXISTS " + Atributos.CREAR_TABLA_CAPACITADOR);
        db.execSQL("DROP TABLE IF EXISTS " + Atributos.CREAR_TABLA_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + Atributos.CREAR_TABLA_PROGRAMAS);
        db.execSQL("DROP TABLE IF EXISTS " + Atributos.CREAR_TABLA_PERSONAS);
        onCreate(db);
    }
}
