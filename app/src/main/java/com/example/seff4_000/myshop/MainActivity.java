package com.example.seff4_000.myshop;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Explicit
    private MyManage objMyManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // request database
        objMyManage = new MyManage(this);

        // Test Add Value
       // testAddValue();

        // Clean data
        cleandata();


    }  //constructure

    private void cleandata() {

        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        objSqLiteDatabase.delete(MyManage.food_Table, null, null);
        objSqLiteDatabase.delete(MyManage.user_Table, null, null);

    }  // cleandata

    private void testAddValue() {

        for (int i = 0; i <= 1; i++) {
            objMyManage.addNewValue(i, "test1", "test2", "test3");
        }  //for

    }  //testAddValue
} //main class
