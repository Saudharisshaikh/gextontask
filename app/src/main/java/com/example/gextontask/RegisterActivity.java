package com.example.gextontask;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    Sqdatabase db;
    EditText editTextname,editTextphone,editTextemail,editTextid;

    Button buttonregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    editTextname=findViewById(R.id.register_username);
    editTextphone=findViewById(R.id.register_phoneinput);
    editTextemail=findViewById(R.id.register_email);
    editTextid=findViewById(R.id.register_id);
    buttonregister=findViewById(R.id.register_loginbutton);

    db=new Sqdatabase(this);

    buttonregister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            createAccout();
        }
    });

    }

    private void createAccout() {


        String name=editTextname.getText().toString();
        String email=editTextemail.getText().toString();
        String phone=editTextphone.getText().toString();


        if(TextUtils.isEmpty(name)){

            Toast.makeText(this, "Please write your name ....", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(phone)){

            Toast.makeText(this, "Please write your Phone no ....", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(email)){

            Toast.makeText(this, "Please write your Password ....", Toast.LENGTH_SHORT).show();
        }


        else {


        db.insert_employee(name,email,phone);

            Toast.makeText(this, "Insert successfully...", Toast.LENGTH_SHORT).show();
        }
    }
}