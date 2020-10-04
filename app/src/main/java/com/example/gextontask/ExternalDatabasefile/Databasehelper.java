package com.example.gextontask.ExternalDatabasefile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Databasehelper extends SQLiteAssetHelper {

    private static final String databasename="newdatabase.db";
    private static final int databaseversion=1;

    public Databasehelper(Context context) {
        super(context, databasename, null, databaseversion);
    }
}
