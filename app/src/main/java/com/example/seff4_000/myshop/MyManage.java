package com.example.seff4_000.myshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by seff4_000 on 6/2/2559.
 */
public class MyManage {

    private MyOpenHelper objMyOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String user_Table = "userTable";
    public static final String food_Table = "food";
    public static final String column_ID = "_id";
    public static final String column_User = "User";
    public static final String column_Password = "Password";
    public static final String column_Name = "Name";
    public static final String column_Food = "Food";
    public static final String column_Price = "Price";
    public static final String column_Source = "Source";


    public MyManage(Context context) {

        //create and connect database
        objMyOpenHelper = new MyOpenHelper(context);
        writeSqLiteDatabase = objMyOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMyOpenHelper.getReadableDatabase();

    }  //construture

    public long addNewValue(int intTable,
                            String strColumn2,
                            String strColumn3,
                            String strColumn4) {

        ContentValues objContentValues = new ContentValues();
        long longReturn = 0;

        switch (intTable) {
            case 0:

                objContentValues.put(column_User,strColumn2);
                objContentValues.put(column_Password,strColumn3);
                objContentValues.put(column_Name,strColumn4);
                writeSqLiteDatabase.insert(user_Table, null, objContentValues);

                break;

            case 1:

                objContentValues.put(column_Food,strColumn2);
                objContentValues.put(column_Price,strColumn3);
                objContentValues.put(column_Source,strColumn4);
                writeSqLiteDatabase.insert(user_Table, null, objContentValues);

                break;
        }

        return 0;
    }

}  //main class
