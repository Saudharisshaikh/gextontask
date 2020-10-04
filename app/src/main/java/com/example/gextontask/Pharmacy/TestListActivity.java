package com.example.gextontask.Pharmacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.gextontask.R;

import java.util.ArrayList;

public class TestListActivity extends AppCompatActivity {

    ListView listView;
    Mysqdatabase mysqdatabase;
    SQLiteDatabase db;
    Adapters adapters;
    Myowncustomadapter myowncustomadapter;
    ArrayList<Pharma> pharmas;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);

        listView=findViewById(R.id.mylist);
        mysqdatabase=new Mysqdatabase(this);
        db=mysqdatabase.getReadableDatabase();
        adapters=new Adapters(this,R.layout.myadapterlist);

             //pharmas= (ArrayList<Pharma>) mysqdatabase.GetData();

  /*      adapters.add(pharmas);
        listView.setAdapter(adapters);*/


/*
        myowncustomadapter=new Myowncustomadapter(this,pharmas);
        listView.setAdapter(myowncustomadapter);*/






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.mymenu,menu);
        return  true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.UpdateData){

            Intent intent=new Intent(TestListActivity.this,FurtherAction.class);
            startActivity(intent);
        }
       else if(item.getItemId()==R.id.DeleteDat){

            Intent intent=new Intent(TestListActivity.this,FurtherAction.class);
            startActivity(intent);
       }

      else   if(item.getItemId()==R.id.Search_byname){

            String Names="Alp";

            cursor=mysqdatabase.getz(Names);
            listView.setAdapter(adapters);

            if (cursor.moveToFirst()){

                do{

                    String id,name,formula,company;
                    id=cursor.getString(0);
                    name=cursor.getString(1);
                    formula=cursor.getString(2);
                    company=cursor.getString(3);

                    Pharma pharma=new Pharma(id,name,formula,company);

                    adapters.add(pharma);
                }
                while (cursor.moveToNext());
            }

        }
      else   if(item.getItemId()==R.id.Search_byformula){

            String Names="about";

            cursor=mysqdatabase.getz(Names);
            listView.setAdapter(adapters);

//            pharmas= (ArrayList<Pharma>) mysqdatabase.GetSearchbyformualaname(Names);
           /* adapters=new Adapters(this,R.layout.myadapterlist);
            adapters.add(pharmas);
            listView.setAdapter(adapters);
*/

//            myowncustomadapter=new Myowncustomadapter(this,pharmas);
//            listView.setAdapter(myowncustomadapter);


            if (cursor.moveToFirst()){

                do{

                    String id,name,formula,company;
                    id=cursor.getString(0);
                    name=cursor.getString(1);
                    formula=cursor.getString(2);
                    company=cursor.getString(3);

                    Pharma pharma=new Pharma(id,name,formula,company);

                    adapters.add(pharma);
                }
                while (cursor.moveToNext());
            }
        }
    else     if(item.getItemId()==R.id.Search_bycompany){



            String Names="about";

            cursor=mysqdatabase.getz(Names);
            listView.setAdapter(adapters);


            if (cursor.moveToFirst()){

                do{

                    String id,name,formula,company;
                    id=cursor.getString(0);
                    name=cursor.getString(1);
                    formula=cursor.getString(2);
                    company=cursor.getString(3);

                    Pharma pharma=new Pharma(id,name,formula,company);

                    adapters.add(pharma);
                }
                while (cursor.moveToNext());
            }


//            String Names="medicinecompany";
//
//            pharmas= (ArrayList<Pharma>) mysqdatabase.GetSearchbycompanyname(Names);
          /*  adapters=new Adapters(this,R.layout.myadapterlist);
            adapters.add(pharmas);
            listView.setAdapter(adapters);*/
//            myowncustomadapter=new Myowncustomadapter(this,pharmas);
//            listView.setAdapter(myowncustomadapter);
        }

    else {


//            pharmas= (ArrayList<Pharma>) mysqdatabase.GetData();
          /*  adapters=new Adapters(this,R.layout.myadapterlist);
            adapters.add(pharmas);
            listView.setAdapter(adapters);*/
        /*    myowncustomadapter=new Myowncustomadapter(this,pharmas);
            listView.setAdapter(myowncustomadapter);
*/        }


     return    true;


    }
}