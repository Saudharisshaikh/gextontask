package com.example.gextontask.Pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gextontask.R;

public class WelcomePageActivity extends AppCompatActivity {

    Button showdata,createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        showdata=findViewById(R.id.showall_data);
        createAccount=findViewById(R.id.create_acccount);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(WelcomePageActivity.this,EnterdataActivity.class);
                startActivity(intent);
            }
        });

        showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(WelcomePageActivity.this,TestListActivity.class);
                startActivity(intent);
            }
        });

    }
}