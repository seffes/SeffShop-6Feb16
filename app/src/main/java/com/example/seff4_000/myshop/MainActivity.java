package com.example.seff4_000.myshop;

import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;

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

        //synchronize JSON to SQLite
        synchronize ();

    }  //constructure

    private void synchronize() {

        StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(myPolicy);

        int intTable = 1;
        String tag = "Shop";

        while (intTable <= 2) {
            // กฏ1 create inputStream
            InputStream objInputStream = null;
            String strURLuser = "http://swiftcodingthai.com/6feb/php_get_data_SEFF.php";
            String strURLfood = "http://swiftcodingthai.com/6feb/php_get_data_food.php";

            try {

            } catch (Exception e) {
                Log.d(tag, "InputSttream ==>" + e.toString());
            }

            //2 create JSON String

            //3 UpdateSQLite(เปลี่ยนสตริงเป็นข้อมูล แล้วอัพขึ้น SQLite)


            intTable += 1;
        }  //while
    }  //synchronize

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
