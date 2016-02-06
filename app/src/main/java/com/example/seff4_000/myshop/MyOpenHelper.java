package com.example.seff4_000.myshop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by seff4_000 on 6/2/2559.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //ประกาศตัวแปร
    public static final String database_name = "Shop.db";  //final บอกว่าจะเปลี่ยนแปลงไม่ได้
    private static final int database_version = 1;
    private static final String create_user_table = "create table userTable (" +
            "_id integer primary key," +   //คอลัมแรกจะเป็นไอดีเท่านั้นสำหรับ sqlite
            "User text," +
            "Pasword text," +
            "Name text);";
    private static final String Create_food_table = "create table food (" +
            "_id integer primary key," +
            "Food text," +
            "Price text," +
            "Source text);";

    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);


    }  //comstructure

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_user_table);
        db.execSQL(Create_food_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}  // main class
