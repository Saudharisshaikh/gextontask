package com.example.gextontask.SaveImageInDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class Dbhelperimage extends SQLiteOpenHelper {

    public static String databasename="imagedatbase";
    public static int dabaseversionno=1;
    public static String Tablename="ImageInfo";
    public static String imagename="imagename";
    public static String image="image";
    ByteArrayOutputStream byteArrayOutputStream;
    byte[] imageinByte;
    public Dbhelperimage(@Nullable Context context) {
        super(context, databasename, null, dabaseversionno);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+Tablename+" ("+imagename+" TEXT,"+image+" BLOB)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Tablename);
        onCreate(sqLiteDatabase);
    }
    public void StoreImage(ImageModel imageModel){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Bitmap imagetostore=imageModel.getImage();
        byteArrayOutputStream=new ByteArrayOutputStream();
        imagetostore.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        imageinByte=byteArrayOutputStream.toByteArray();

        ContentValues contentValues=new ContentValues();
        contentValues.put(imagename,imageModel.getImageName());
        contentValues.put(image,imageinByte);

        sqLiteDatabase.insert(Tablename,null,contentValues);
        sqLiteDatabase.close();

    }

    public ArrayList<ImageModel> arrayList(){

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        ArrayList<ImageModel> dbhelperimageslist =new ArrayList<>();

       Cursor cursor= sqLiteDatabase.rawQuery("SELECT * FROM "+Tablename,null);
        if(cursor.getCount()!=0){

            while (cursor.moveToNext()){

                String name=cursor.getString(0);
                byte[] bytes=cursor.getBlob(1);

                Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);

                dbhelperimageslist.add(new ImageModel(name,bitmap));
            }
            return dbhelperimageslist;

        }
        else {


        }

        return dbhelperimageslist;
    }
}
