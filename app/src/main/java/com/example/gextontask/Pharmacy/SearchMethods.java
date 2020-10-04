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

public class SearchMethods extends AppCompatActivity {

    EditText inputs,formula,company;
    Button button;
    Mysqdatabase mysqdatabase;
    SQLiteDatabase sqLiteDatabase;
Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_methods);
    button=findViewById(R.id.searchbuttons);
    inputs=findViewById(R.id.searchinputs);
    formula=findViewById(R.id.formulas);
    company=findViewById(R.id.companys);
    mysqdatabase=new Mysqdatabase(this);
    sqLiteDatabase=mysqdatabase.getReadableDatabase();

    final String gets=inputs.getText().toString();


    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (TextUtils.isEmpty(gets)){

                Toast.makeText(SearchMethods.this, "Please write medicine name", Toast.LENGTH_SHORT).show();
            }
             else {

                 c=mysqdatabase.getzname(gets);
                 if (c.moveToFirst()){

                     String form=c.getString(0);
                     String comp=c.getString(1);

                     formula.setText(form);
                     company.setText(comp);
                     formula.setVisibility(View.VISIBLE);
                    company.setVisibility(View.VISIBLE);
                 }

            }
        }
    });


    }
}