package com.example.gextontask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    EditText id,name,email,phone;
    Button Update,Delete,Call,SMS,Email;
    Button Action;

   public String Getid;
    public long ID;
    String Getphone;
    String Getname;
    String Getemail;
    Sqdatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        db=new Sqdatabase(this);

         Getid=getIntent().getStringExtra("id").toString();
         Getname=getIntent().getStringExtra("name").toString();
         Getemail=getIntent().getStringExtra("email").toString();
         Getphone=getIntent().getStringExtra("phone").toString();


        id=findViewById(R.id.detail_id);
        name=findViewById(R.id.detail_name);
        email=findViewById(R.id.detail_email);
        phone=findViewById(R.id.detail_phone);

        Update=findViewById(R.id.detail_update);
        Delete=findViewById(R.id.detail_delete);
        Call=findViewById(R.id.detail_call);
        SMS=findViewById(R.id.detail_sms);
        Email=findViewById(R.id.detail_doemail);

        Action=findViewById(R.id.detail_doaction);


        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name.setVisibility(View.VISIBLE);
                email.setVisibility(View.VISIBLE);
                phone.setVisibility(View.VISIBLE);

                name.setText(Getname);
                email.setText(Getemail);
                phone.setText(Getphone);

                id.setVisibility(View.INVISIBLE);

                Update.setVisibility(View.INVISIBLE);
                Delete.setVisibility(View.INVISIBLE);
                Call.setVisibility(View.INVISIBLE);
                SMS.setVisibility(View.INVISIBLE);
                Email.setVisibility(View.INVISIBLE);

                Action.setVisibility(View.VISIBLE);
                Action.setText("Update");


            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name.setVisibility(View.INVISIBLE);
                email.setVisibility(View.INVISIBLE);
                phone.setVisibility(View.INVISIBLE);
                id.setVisibility(View.VISIBLE);
                id.setText(Getid);

                Update.setVisibility(View.INVISIBLE);
                Delete.setVisibility(View.INVISIBLE);
                Call.setVisibility(View.INVISIBLE);
                SMS.setVisibility(View.INVISIBLE);
                Email.setVisibility(View.INVISIBLE);

                Action.setVisibility(View.VISIBLE);
                Action.setText("Delete");
            }
        });

        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                name.setVisibility(View.VISIBLE);
                name.setHint("To");
                email.setVisibility(View.VISIBLE);
                email.setHint("Subject");
                phone.setVisibility(View.VISIBLE);
                phone.setHint("Type email here....");
                id.setVisibility(View.INVISIBLE);
               /* id.setText(Getid);*/

                Update.setVisibility(View.INVISIBLE);
                Delete.setVisibility(View.INVISIBLE);
                Call.setVisibility(View.INVISIBLE);
                SMS.setVisibility(View.INVISIBLE);
                Email.setVisibility(View.INVISIBLE);

                Action.setVisibility(View.VISIBLE);
                Action.setText("Email");
            }
        });


        SMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name.setVisibility(View.VISIBLE);
                name.setHint("Type Message here");
                email.setVisibility(View.INVISIBLE);
                phone.setVisibility(View.VISIBLE);
                phone.setText(Getphone);
                id.setVisibility(View.INVISIBLE);

                Update.setVisibility(View.INVISIBLE);
                Delete.setVisibility(View.INVISIBLE);
                Call.setVisibility(View.INVISIBLE);
                SMS.setVisibility(View.INVISIBLE);
                Email.setVisibility(View.INVISIBLE);

                Action.setVisibility(View.VISIBLE);
                Action.setText("SMS");

                SendSms();
            }
        });

        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name.setVisibility(View.INVISIBLE);
                email.setVisibility(View.INVISIBLE);
                phone.setVisibility(View.VISIBLE);
                phone.setText(Getphone);
                id.setVisibility(View.INVISIBLE);

                Update.setVisibility(View.INVISIBLE);
                Delete.setVisibility(View.INVISIBLE);
                Call.setVisibility(View.INVISIBLE);
                SMS.setVisibility(View.INVISIBLE);
                Email.setVisibility(View.INVISIBLE);

                Action.setVisibility(View.VISIBLE);
                Action.setText("Call");

            }
        });

        Action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Action.getText().equals("Update")){

                    UpdateData();
                    Toast.makeText(DetailActivity.this, "Values Updated successfully..", Toast.LENGTH_SHORT).show();
                }
                else if(Action.getText().equals("Delete")){

                    DeleteData();
                }
                else if (Action.getText().equals("SMS")){

                    SMSnow();
                }

                else if (Action.getText().equals("Call")){

                    Callnow();
                }

                else if (Action.getText().equals("Email")){

                    EmailNow();
                }
            }
        });
    }

    private void EmailNow() {

        String To=name.getText().toString();
        String subject=email.getText().toString();
        String typeemail=phone.getText().toString();

        Intent emailintent=new Intent(Intent.ACTION_SEND);
        emailintent.putExtra(Intent.EXTRA_EMAIL,new String[]{To});
        emailintent.putExtra(Intent.EXTRA_SUBJECT,subject);
        emailintent.putExtra(Intent.EXTRA_TEXT,typeemail);

        emailintent.setType("message/rfc822");

        startActivity(Intent.createChooser(emailintent,"Choose Email client :"));

    }

    private void Callnow() {

        Intent intent=new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",Getphone,null));
//        intent.setData(Uri.parse(Getphone));

        if (ContextCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CALL_PHONE)==PackageManager.PERMISSION_GRANTED){

            startActivity(intent);
        }

        else {

            ActivityCompat.requestPermissions(DetailActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);

            Toast.makeText(this, "Please allow the call permission...", Toast.LENGTH_SHORT).show();
        }
    }



    private void SendSms() {

        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){

            String message=name.getText().toString();
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(Getphone,null,message,null,null);

            Toast.makeText(this, ""+Getphone+""+Getname, Toast.LENGTH_SHORT).show();
        }
        else {

            ActivityCompat.requestPermissions(DetailActivity.this,new String[]{Manifest.permission.SEND_SMS},102);

            Toast.makeText(this, "Please Allow permission to Send SMS...", Toast.LENGTH_SHORT).show();
        }

    }

    private void SMSnow() {

        SendSms();
        Toast.makeText(this, "SMS send successfully....", Toast.LENGTH_SHORT).show();
    }

    private void DeleteData() {

        ID=Long.parseLong(Getid);
        db.deletestudent(ID);


    }

    private void UpdateData() {

        String updatename=name.getText().toString();
        String updateemail=email.getText().toString();
        String updatephone=phone.getText().toString();
        ID=Long.parseLong(Getid);
        db.updatestudent(ID,updatename,updateemail,updatephone);
    }

}