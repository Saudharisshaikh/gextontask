package com.example.gextontask.MyExternalTest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class Testdbaccess  {

    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper sqLiteOpenHelper;
    Cursor cursor;
   private static Testdbaccess instance;

    Testdbaccess(Context context){

        this.sqLiteOpenHelper=new Testdbhelper(context);
    }

    public static Testdbaccess Getinstance(Context context){

        if(instance==null){

            instance=new Testdbaccess(context);
        }
        return instance;
    }
    public void open(){

        this.sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();

    }


    public Cursor getmydata(){

        String Name="Name";
        String Email="Email";
        String Phone="Phone";
        ArrayList<TestModel> testModels=new ArrayList<>();

        String [] columns={Name,Email,Phone};
         String Tablename="testtable";

        cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+Tablename,null);

       /* if (cursor!=null) {

            Log.d("---","test");
            while (cursor.moveToNext()) {

                String name = cursor.getString(0);
                String email = cursor.getString(1);
                String phone = cursor.getString(2);

                TestModel testModel = new TestModel(name, email, phone);

                testModels.add(testModel);
            }
        }
        else {
            Log.d("Mytag","Error.......");
        }
        return testModels;
*/
return cursor;

    }

    public String getAddress(){

        String Email="Email";
        String name="Saqib";
        cursor=sqLiteDatabase.rawQuery("SELECT Email From testtable where Name = '"+name+"'",new String[]{});
        StringBuffer stringBuffer=new StringBuffer();
        while (cursor.moveToNext()){

            String address=cursor.getString(0);
            stringBuffer.append(""+address);

        }
        return stringBuffer.toString();
    }

    public  Cursor GetEmail(){

        String table="testtable";
        Cursor cursors=sqLiteDatabase.rawQuery("SELECT Email from "+table,null);
        return cursors;
    }
}
