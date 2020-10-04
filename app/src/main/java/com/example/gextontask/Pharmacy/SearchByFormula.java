package com.example.gextontask.Pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gextontask.R;

public class SearchByFormula extends AppCompatActivity {

    EditText editTextsearch;
    Button buttons;
    ListView listView;
    Cursor cursor;
    Mysqdatabase mysqdatabase;
    SQLiteDatabase database;
    Adapters adapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_formula);
        adapters=new Adapters(this,R.layout.myadapterlist);
        listView=findViewById(R.id.searchlist);
    editTextsearch=findViewById(R.id.Formula);
    buttons=findViewById(R.id.Buttonofseach);

    mysqdatabase=new Mysqdatabase(this);
    database=mysqdatabase.getReadableDatabase();
     listView.setAdapter(adapters);



          /* if (TextUtils.isEmpty(name)){

               Toast.makeText(SearchByFormula.this, "Please enter name to search..", Toast.LENGTH_SHORT).show();
           }

           else {*/

            //   Toast.makeText(SearchByFormula.this, ""+name, Toast.LENGTH_SHORT).show();


               cursor=mysqdatabase.GetSearchbyformualaname();
               if (cursor.moveToFirst()){

                   do {
                       String i = cursor.getString(0);
                       String n = cursor.getString(1);
                       String f = cursor.getString(2);
                       String c = cursor.getString(3);

                       Pharma pharma = new Pharma(i, n, f, c);
                       adapters.add(pharma);

                   }
while (cursor.moveToNext());
               }
           }
     //  }


    }
