package com.dal.dalevents.client.sqlite;

import android.database.sqlite.SQLiteDatabase;

public class SqliteHelper {
	

	public static final String TABLE_LOG="log";
	public static final String LOG_ID="_id";
	public static final String LOG_TITLE="title";
	public static final String LOG_DATA="summary";
	public static final String LOG_DATE="date";
	public static final String LOG_TIME="time";
	
	private static final String DATABASE_CREATE="create table "
			+ TABLE_LOG
			+ "("
			+ LOG_ID + " text not null,"
			+ LOG_TITLE + " text not null, "
			+ LOG_DATA +" text not null, "
			+ LOG_DATE +" text not null, "
			+ LOG_TIME +" text not null"
		    + ");";
	
	public static void onCreate(SQLiteDatabase database)
	{
		database.execSQL(DATABASE_CREATE);
	}

	public static void onUpgrade(SQLiteDatabase database,int oldversion,int newversion)
	{
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_LOG);
	    onCreate(database);	
	}

}
