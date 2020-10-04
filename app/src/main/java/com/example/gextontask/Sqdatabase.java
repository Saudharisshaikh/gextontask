package com.example.gextontask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Sqdatabase extends SQLiteOpenHelper {

    SQLiteDatabase db;

    private static final String database_name="user_info";
    private  static final int database_version=1;

    private static final String table_name="thisuser";

    public static final String KEY_user="username";
    public static final String Key_phone="phone";
    public static final String Key_email="email";
    public static  final String  Key_id="id";

    public Sqdatabase(@Nullable Context context) {
        super(context, database_name, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String create_table="CREATE TABLE IF NOT EXISTS "+table_name+" ("+Key_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                KEY_user+" TEXT ,"+Key_email+" TEXT ,"+Key_phone+" TEXT)";

        sqLiteDatabase.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(sqLiteDatabase);
    }

    public long insert_employee(String name, String email,String phone) {
        db=getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put(KEY_user,name);
        cv.put(Key_email,email);
        cv.put(Key_phone,phone);

        return db.insert(table_name,null,cv);
    }

    public String getData() {
        db=this.getReadableDatabase();

        String []on=new String[]{Key_id,KEY_user,Key_email,Key_email};
        Cursor cursor=db.query(table_name,on,null,null,null,null,null);
        int iRow=cursor.getColumnIndex(Key_id);
        String result=null;

        int firstname=cursor.getColumnIndex(KEY_user);
        int useremail=cursor.getColumnIndex(Key_email);
        int userphone=cursor.getColumnIndex(Key_phone);

        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){

            result=result+cursor.getString(iRow)+" "+cursor.getString(firstname)+" "+cursor.getString(useremail)+" "+cursor.getString(userphone)+"\n";
        }
        db.close();
        return result;
    }

    public String getfirstname(Long l) {
        db=this.getReadableDatabase();

        String []on=new String[]{Key_id,KEY_user,Key_email,Key_phone};
        Cursor cursor=db.query(table_name,on,Key_id+"="+l,null,null,null,null);
        if(cursor!=null){

            cursor.moveToFirst();
            String name=cursor.getString(1);
            return  name;
        }
        return null;
    }

    public String getemail(Long l) {
        db=this.getReadableDatabase();

        String []on=new String[]{Key_id,KEY_user,Key_email,Key_phone};
        Cursor cursor=db.query(table_name,on,Key_id+"="+l,null,null,null,null);
        if(cursor!=null){

            cursor.moveToFirst();
            String name=cursor.getString(2);
            return  name;
        }
        return null;
    }

    public String getphone(Long l) {
        db=this.getReadableDatabase();

        String []on=new String[]{Key_id,KEY_user,Key_email,Key_phone};
        Cursor cursor=db.query(table_name,on,Key_id+"="+l,null,null,null,null);
        if(cursor!=null){

            cursor.moveToFirst();
            String name=cursor.getString(3);
            return  name;
        }
        return null;
    }

    public void updatestudent(Long l, String name, String email,String phone) {
        db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_user,name);
        cv.put(Key_email,email);
        cv.put(Key_phone,phone);
        db.update(table_name,cv,Key_id+"="+l,null);
        db.close();

    }

    public void deletestudent(Long l) {

        db=this.getWritableDatabase();
        db.delete(table_name,Key_id+"="+l,null);
    }

    public Cursor getAlldata(){

        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor result=sqLiteDatabase.rawQuery("SELECT * FROM "+table_name,null);
        return result;

    }
}
