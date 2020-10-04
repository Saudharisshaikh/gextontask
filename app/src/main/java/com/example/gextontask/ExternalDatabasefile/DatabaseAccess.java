package com.example.gextontask.ExternalDatabasefile;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess  {

    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    private static DatabaseAccess instance;
    Cursor c;

    private DatabaseAccess(Context context){

        this.sqLiteOpenHelper=new Databasehelper(context);
    }

    public static DatabaseAccess getInstance(Context context){

        if (instance==null){

            instance=new DatabaseAccess(context);
        }
        return instance;
    }
    public void open(){

        this.sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();
    }
    public void close(){

        if (sqLiteDatabase!=null){

            this.sqLiteDatabase.close();
        }
    }

    public String getAddress(String name){

        c=sqLiteDatabase.rawQuery("SELECT Address From mytable where Name = '"+name+"'",new String[]{});
        StringBuffer stringBuffer=new StringBuffer();
        while (c.moveToNext()){

            String address=c.getString(0);
            stringBuffer.append(""+address);

        }
        return stringBuffer.toString();
    }
}
