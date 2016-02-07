package com.example.seff4_000.myshop;

import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

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
            HttpPost objHttpPost = null;

            try {

                HttpClient objHttpClient = new DefaultHttpClient();
                switch (intTable) {
                    case 1:
                        objHttpPost = new HttpPost(strURLuser);
                        break;
                    case 2:
                        objHttpPost = new HttpPost(strURLfood);
                        break;
                }  //switch

                HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
                HttpEntity objHttpEntity = objHttpResponse.getEntity();
                objInputStream = objHttpEntity.getContent();

            } catch (Exception e) {
                Log.d(tag, "InputSttream ==>" + e.toString());
            }


            //2 create JSON String
            String strJSON = null;

            try {
                // ประมวลผล
                BufferedReader objBufferedReader = new BufferedReader(new InputStreamReader(objInputStream, "UTF-8"));
                StringBuilder objStringBuilder = new StringBuilder();
                String strline = null;

                // StringBuilder จะเป็นการตัดแบ่งส่วนเพื่อโยนไปเก็บ
                while ((strline = objBufferedReader.readLine()) != null) {
                    objStringBuilder.append(strline);
                } //while

                objInputStream.close();
                strJSON = objStringBuilder.toString();

            } catch (Exception e) {
                Log.d(tag, "Inputstream ==> " + e.toString());
            }


            //3 UpdateSQLite(เปลี่ยนสตริงเป็นข้อมูล แล้วอัพขึ้น SQLite)
            try {

                JSONArray objJsonArray = new JSONArray(strJSON);
                for (int i = 0; i < objJsonArray.length(); i++) {

                    JSONObject jsonObject = objJsonArray.getJSONObject(i);

                    switch (intTable) {
                        case 1:

                            //get value from userTable
                            String strUser = jsonObject.getString(MyManage.column_User);
                            String strPassword = jsonObject.getString(MyManage.column_Password);
                            String strName = jsonObject.getString(MyManage.column_Name);

                            objMyManage.addNewValue(0, strUser, strPassword, strName); //ใช้ 0 เพราะในMyManage ใช้เลข0 เลือก

                            break;

                        case 2:

                            //get value from food Table
                            String strFood = jsonObject.getString(MyManage.column_Food);
                            String strPrice = jsonObject.getString(MyManage.column_Price);
                            String strSource = jsonObject.getString(MyManage.column_Source);

                            objMyManage.addNewValue(1, strFood, strPrice, strSource);

                            break;
                    }

                }  //for

            } catch (Exception e) {
                Log.d(tag, "Update ==> " + e.toString());
            }

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
