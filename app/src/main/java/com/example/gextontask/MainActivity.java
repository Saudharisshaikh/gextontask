package com.example.gextontask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addAccount,showdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    addAccount=findViewById(R.id.add_account);
    showdata=findViewById(R.id.show_account);


    addAccount.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent);
        }
    });

    showdata.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent=new Intent(MainActivity.this,ShowListView.class);
            startActivity(intent);
        }
    });


    }
}