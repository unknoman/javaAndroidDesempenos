package com.example.sqlproyecto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

	public AdminSQLiteOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		}
	
	


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table votantes1(dni integer primary key, nombre text, colegio text)");
		
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("drop table if exists votantes1");
		db.execSQL("create table votantes1(dni integer primary key, nombre text, colegio text)"); 
		
	}

	}





