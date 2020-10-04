package com.example.gextontask.Pharmacy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.example.gextontask.Pharmacy.constantstable.Table_name;
import static com.example.gextontask.Pharmacy.constantstable.createTable;
import static com.example.gextontask.Pharmacy.constantstable.medicineId;
import static com.example.gextontask.Pharmacy.constantstable.medicinecompany;
import static com.example.gextontask.Pharmacy.constantstable.medicineformula;
import static com.example.gextontask.Pharmacy.constantstable.medicinename;

public class Mysqdatabase extends SQLiteOpenHelper {

   public static String databasename="PharmaDatabase";
   public static   int database_version=1;

    Cursor cs ;
   SQLiteDatabase db;

    public Mysqdatabase(@Nullable Context context) {
        super(context, databasename, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Table_name);
        onCreate(sqLiteDatabase);
    }

    public void InsertData(String Name,String Formula,String Company){

        db=getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(medicinename,Name);
        cv.put(medicineformula,Formula);
        cv.put(medicinecompany,Company);

        db.insert(Table_name,null,cv);
    }

    public void DeleteData(Long l){

        db=getWritableDatabase();
        db.delete(Table_name,medicineId+"="+l,null);
        db.close();
    }

    public void update(Long l,String Name,String Formula,String Company){

        db=getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(medicinename,Name);
        cv.put(medicineformula,Formula);
        cv.put(medicinecompany,Company);

        db.update(Table_name,cv,medicineId+"="+l,null);
    }

    public List<Pharma> GetData(){

        String columns[]={medicineId,medicinename,medicineformula,medicinecompany};
        db=getReadableDatabase();
        ArrayList<Pharma> pharmas =new ArrayList<>() ;
        String id,name,formula,company;
        Cursor cursor=db.query(Table_name,columns,null,null,null,null,medicinename);
        if(cursor.moveToNext()){

             id=cursor.getString(0);
             name=cursor.getString(1);
             formula=cursor.getString(2);
             company=cursor.getString(3);

            Pharma pharma=new Pharma(id,name,formula,company);

            pharmas.add(pharma);
        }

        return pharmas;
    }

    public List<Pharma> GetSearchbyname(String Selection){

        String columns[]={medicineId,medicinename,medicineformula,medicinecompany};
        db=getReadableDatabase();
        List<Pharma> pharmas = null;
        String id,name,formula,company;

        String select[]={Selection};
        Cursor cursor=db.query(Table_name,columns,medicinename+"=?",select,null,null,null);
        if(cursor.moveToNext()){

            id=cursor.getString(0);
            name=cursor.getString(1);
            formula=cursor.getString(2);
            company=cursor.getString(3);

            Pharma pharma=new Pharma(id,name,formula,company);

            pharmas.add(pharma);
        }

        return pharmas;
    }

    public List<Pharma> GetSearchbycompanyname(String Selection){

        String columns[]={medicineId,medicinename,medicineformula,medicinecompany};
        db=getReadableDatabase();
        List<Pharma> pharmas = null;
        String id,name,formula,company;

        String select[]={Selection};
        Cursor cursor=db.query(Table_name,columns,medicinecompany+"=?",select,null,null,null);
        if(cursor.moveToNext()){

            id=cursor.getString(0);
            name=cursor.getString(1);
            formula=cursor.getString(2);
            company=cursor.getString(3);

            Pharma pharma=new Pharma(id,name,formula,company);

            pharmas.add(pharma);
        }

        return pharmas;
    }

    public Cursor GetSearchbyformualaname(){

        String columns[]={medicineId,medicinename,medicineformula,medicinecompany};
     /*   db=getReadableDatabase();
        List<Pharma> pharmas = null;
        String id,name,formula,company;*/

      //  String select[]={Selection};
        Cursor cs=db.query(Table_name,columns,null,null,null,null,null,null);
        /*if(cursor.moveToNext()){

            id=cursor.getString(0);
            name=cursor.getString(1);
            formula=cursor.getString(2);
            company=cursor.getString(3);

            Pharma pharma=new Pharma(id,name,formula,company);

            pharmas.add(pharma);
        }

        return pharmas;*/

        return cs;
    }

    public Cursor getz(String selection){


        //SQLiteDatabase sqLiteDatabase=getReadableDatabase();
      //  Cursor res=sqLiteDatabase.rawQuery("SELECT * FROM "+Table_name,null);

        String[] select={selection};


        String[] columns={medicineId,medicinename,medicineformula,medicinecompany};
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        if(selection==null) {
            cs = sqLiteDatabase.query(Table_name, columns, null, null, null, null, medicinename);
            //order by value.

        }
        else {

            cs=sqLiteDatabase.query(Table_name,columns,medicinecompany+"=?",select,null,null,null,null);
        }
        return cs;
    }

    public Cursor getzname(String Selection)
    {

        String[] select={Selection};
        String[] columns={medicineformula,medicinecompany};
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cs=db.query(Table_name,columns,medicinename+"=?",select,null,null,null);
        return cs;
    }
    public Cursor getzformula(String Selection)
    {

        String[] select={Selection};
        String[] columns={medicineformula,medicinecompany};
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cs=db.query(Table_name,columns,medicineformula+"=?",select,null,null,null);
        return cs;
    }

    public Cursor getzcompany(String Selection)
    {

        String[] select={Selection};
        String[] columns={medicineformula,medicinecompany};
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cs=db.query(Table_name,columns,medicinecompany+"=?",select,null,null,null);
        return cs;
    }
}
