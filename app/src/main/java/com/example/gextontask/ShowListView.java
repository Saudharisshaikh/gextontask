package com.example.gextontask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowListView extends AppCompatActivity {

    Sqdatabase sqdatabase;
    SQLiteDatabase db;

    ListView listView;
    Cursor cursor;
    ListAdapter listAdapter;
/*
    @Override
    protected void onResume() {
        displaydata();
        super.onResume();


    }*/
//
//    private void displaydata() {
//
//        sqdatabase=new Sqdatabase(this);
//        Cursor cursor=db.rawQuery("SELECT * FROM  thisuser",null);
//
//        Id.clear();
//        Name.clear();
//        Phone.clear();
//        Email.clear();
//
//        if (cursor.moveToFirst()) {
//            do {
//                Id.add(cursor.getString(cursor.getColumnIndex("id")));
//                Name.add(cursor.getString(cursor.getColumnIndex("username")));
//                Email.add(cursor.getString(cursor.getColumnIndex("email")));
//                Phone.add(cursor.getString(cursor.getColumnIndex("phone")));
//            } while (cursor.moveToNext());
//        }
//
//
//        CustomAdapter customAdapter=new CustomAdapter(ShowListView.this,Id,Name,Email,Phone);
//        cursor.close();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_view);


        listView=findViewById(R.id.listview);
        listAdapter=new ListAdapter(this,R.layout.listviewlayout);
        sqdatabase=new Sqdatabase(this);
        db=sqdatabase.getReadableDatabase();
        cursor=sqdatabase.getAlldata();
        listView.setAdapter(listAdapter);

        if(cursor.moveToFirst()){

            do {

                String id,name,email,phone;
                id=cursor.getString(0);
                name=cursor.getString(1);
                email=cursor.getString(2);
                phone=cursor.getString(3);

                User user=new User(id,name,email,phone);

                listAdapter.add(user);

            }
            while (cursor.moveToNext());

        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                User users=(User)adapterView.getItemAtPosition(i);

                String id=users.getId().toString();
                String name=users.getName().toString();
                String email=users.getEmail().toString();
                String phone=users.getPhone().toString();

                Intent intent=new Intent(ShowListView.this,DetailActivity.class);

                intent.putExtra("id",id);
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);

                startActivity(intent);
            }
        });
    }
}