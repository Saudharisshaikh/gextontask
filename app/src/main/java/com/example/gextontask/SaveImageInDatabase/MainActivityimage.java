package com.example.gextontask.SaveImageInDatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gextontask.R;

import java.io.IOException;

public class MainActivityimage extends AppCompatActivity {

    int requestcode=101;
    EditText editTextimagename;
    Button buttonsave,buttonshow;
    ImageView imageView;
    Uri imagePath;
    Bitmap filetoStore;
    Dbhelperimage dbhelperimage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityimage);

    editTextimagename=findViewById(R.id.imagename);
    imageView=findViewById(R.id.images);
    buttonsave=findViewById(R.id.buttonName);
    buttonshow=findViewById(R.id.showImage);


    dbhelperimage=new Dbhelperimage(this);
    imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intentimage=new Intent();
            intentimage.setAction(Intent.ACTION_GET_CONTENT);
            intentimage.setType("image/*");

            startActivityForResult(intentimage,requestcode);

        }
    });

    buttonsave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(!editTextimagename.getText().toString().isEmpty()&&imageView.getDrawable()!=null&&filetoStore!=null){

                dbhelperimage.StoreImage(new ImageModel(editTextimagename.getText().toString(),filetoStore));
            }
            else {
                Toast.makeText(MainActivityimage.this, "Please select imagename and image...", Toast.LENGTH_SHORT).show();
            }
        }
    });

    buttonshow.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent =new Intent(MainActivityimage.this,ShowImageActivity.class);
            startActivity(intent);
        }
    });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==requestcode&&resultCode==RESULT_OK&&data!=null&&data.getData()!=null){


            try {
                imagePath=data.getData();
                filetoStore= MediaStore.Images.Media.getBitmap(getContentResolver(),imagePath);

                imageView.setImageBitmap(filetoStore);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}