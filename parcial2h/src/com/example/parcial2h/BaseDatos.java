package com.example.parcial2h;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {


	public BaseDatos(Context context, String nombre, CursorFactory factory, int version) {
		super(context, nombre, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table productos(codigo integer primary key, nombre text, genero text, precio float)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("drop table if exists productos");
		db.execSQL("create table productos(codigo integer primary key, nombre text, genero text, precio float)"); 

	}

}
