package com.example.gextontask.SaveImageInDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gextontask.R;

public class ShowImageActivity extends AppCompatActivity {

    Button button;
    RecyclerView recyclerView;
    Dbhelperimage dbhelperimage;
    ImageAdapter imageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        button=findViewById(R.id.activityshowimages);
        recyclerView=findViewById(R.id.showrecyclerview);
        dbhelperimage=new Dbhelperimage(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageAdapter=new ImageAdapter(dbhelperimage.arrayList());
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(ShowImageActivity.this));
                recyclerView.setAdapter(imageAdapter);
            }
        });
    }
}