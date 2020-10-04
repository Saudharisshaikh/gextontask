package com.example.gextontask.Pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gextontask.R;

public class EnterdataActivity extends AppCompatActivity {

    Button enterdata;
    EditText editTextid,editTextname,editTextcompany,editTextformula;

    SQLiteDatabase sqLiteDatabase;
    Mysqdatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterdata);

        editTextid =findViewById(R.id.medicine_id);
        editTextname=findViewById(R.id.medicine_name);
        editTextformula=findViewById(R.id.medicine_formula);
        editTextcompany=findViewById(R.id.medicine_company);

        db=new Mysqdatabase(this);
        enterdata=findViewById(R.id.insertdata);

        enterdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DataInserted();
            }
        });
    }

    private void DataInserted() {

        String id=editTextid.getText().toString();
        String name=editTextname.getText().toString();
        String formula =editTextformula.getText().toString();
        String company=editTextcompany.getText().toString();


         if (TextUtils.isEmpty(name)){

            Toast.makeText(this, "Name field is empty , please enter Name in the name field ....", Toast.LENGTH_SHORT).show();
        }
        else   if (TextUtils.isEmpty(formula)){

            Toast.makeText(this, "Formula field is empty , please enter Formula  in the formula  field ....", Toast.LENGTH_SHORT).show();
        }
        else   if (TextUtils.isEmpty(company)){

            Toast.makeText(this, "Company field is empty , please enter Company in the company field ....", Toast.LENGTH_SHORT).show();
        }

        else{


            db.InsertData(name,formula,company);
            Toast.makeText(this, "Inserted successfully", Toast.LENGTH_SHORT).show();

        }

    }
}