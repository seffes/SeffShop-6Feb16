package com.example.seff4_000.myshop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by seff4_000 on 6/2/2559.
 */
public class MyManage {

    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public MyManage(Context context) {

        //create and connect database
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }  //construture
}  //main class
