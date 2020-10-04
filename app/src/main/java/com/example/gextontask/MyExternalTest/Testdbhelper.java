package com.example.gextontask.MyExternalTest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;



public class Testdbhelper extends SQLiteAssetHelper {


    public static final String dabasename="testdatabase.db";
    public static final  int databaseversion=1;
    public Testdbhelper(Context context) {
        super(context, dabasename, null, databaseversion);
    }
}
