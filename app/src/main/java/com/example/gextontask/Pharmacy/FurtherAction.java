package com.example.gextontask.Pharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gextontask.R;

public class FurtherAction extends AppCompatActivity {

    Button buttonupdate,buttondelete,buttonaction;
    EditText editTextid,editTextname,editTextformula ,editTextcompany;

    Mysqdatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_further_action);

        buttonupdate=findViewById(R.id.updateButton);
        buttondelete=findViewById(R.id.deleteButton);
        buttonaction=findViewById(R.id.Actonbutton);

        db=new Mysqdatabase(this);


        editTextid=findViewById(R.id.listshowId);
        editTextname=findViewById(R.id.listshowName);
        editTextformula=findViewById(R.id.listshowFormula);
        editTextcompany=findViewById(R.id.listshowCompany);

        buttonupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editTextname.setVisibility(View.VISIBLE);
                editTextformula.setVisibility(View.VISIBLE);
                editTextcompany.setVisibility(View.VISIBLE);
                editTextid.setVisibility(View.VISIBLE);
                buttondelete.setVisibility(View.INVISIBLE);
                buttonupdate.setVisibility(View.INVISIBLE);

                buttonaction.setVisibility(View.VISIBLE);
                buttonaction.setText("Update");
            }
        });
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editTextid.setVisibility(View.VISIBLE);
                editTextname.setVisibility(View.INVISIBLE);
                editTextformula.setVisibility(View.INVISIBLE);
                editTextcompany.setVisibility(View.INVISIBLE);

                buttondelete.setVisibility(View.INVISIBLE);
                buttonupdate.setVisibility(View.INVISIBLE);

                buttonaction.setVisibility(View.VISIBLE);
                buttonaction.setText("Delete");
            }
        });

        buttonaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(buttonaction.getText().equals("Update")){

                    Updatemydata();
                }
                else if (buttonaction.getText().equals("Delete")){

                    DeletemyData();
                }
            }
        });
    }

    private void DeletemyData() {

        String getids=editTextid.getText().toString();
        Long ID;

        if(TextUtils.isEmpty(getids)){

            Toast.makeText(this, "Please enter Id", Toast.LENGTH_SHORT).show();
        }
        else {

            ID=Long.parseLong(getids);
            db.DeleteData(ID);
        }
    }

    private void Updatemydata() {

        String getname=editTextname.getText().toString();
        String getcompany=editTextcompany.getText().toString();
        String getformula=editTextformula.getText().toString();
        String getmyid=editTextid.getText().toString();

        Long updateId;
        if (TextUtils.isEmpty(getname)){

            Toast.makeText(this, "Please enter medicine name", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(getcompany)){

            Toast.makeText(this, "Please enter company name", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(getformula)){

            Toast.makeText(this, "Please enter formula name", Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(getmyid)){
            Toast.makeText(this, "Please enter medicine id", Toast.LENGTH_SHORT).show();
        }
        else {

            updateId=Long.parseLong(getmyid);
            db.update(updateId,getname,getformula,getcompany);
        }
    }
}