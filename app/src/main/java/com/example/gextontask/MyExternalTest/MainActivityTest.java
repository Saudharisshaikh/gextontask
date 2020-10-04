package com.example.gextontask.MyExternalTest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gextontask.R;

import java.util.ArrayList;

public class MainActivityTest extends AppCompatActivity {

  //  RecyclerView recyclerView;
    RecycleAdapter recycleAdapter;
    Exadapter exadapter;
    Testdbaccess testdbaccess;
    ArrayList<Exmodel> exmodels;
    ArrayList<TestModel> testModels;
    TextView textView;
    Cursor cursor;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        testModels=new ArrayList<>();
        listView=findViewById(R.id.testlistview);
        textView=findViewById(R.id.testtv);
//        recyclerView=findViewById(R.id.recyclerviewtest);
        testdbaccess=Testdbaccess.Getinstance(getApplicationContext());
        testdbaccess.open();

/*        exmodels=new ArrayList<>();
        cursor=testdbaccess.GetEmail();*/

        cursor=testdbaccess.getmydata();

        while (cursor.moveToNext()) {

            String name = cursor.getString(0);
            String email = cursor.getString(1);
            String phone = cursor.getString(2);

            TestModel testModel = new TestModel(name, email, phone);

            testModels.add(testModel);
        }

        recycleAdapter=new RecycleAdapter(this,testModels);
        listView.setAdapter(recycleAdapter);

       // testModels=testdbaccess.getmydata();
/*        recycleAdapter=new RecycleAdapter(testModels);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
       recyclerView.setAdapter(recycleAdapter);*/

      /*  while (cursor.moveToNext()){

            String string=cursor.getString(0);
            Exmodel exmodel=new Exmodel(string);
             exmodels.add(exmodel);


        }

        exadapter=new Exadapter(exmodels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(exadapter);

       String get=testdbaccess.getAddress();

       textView.setText(get);*/

    }
}