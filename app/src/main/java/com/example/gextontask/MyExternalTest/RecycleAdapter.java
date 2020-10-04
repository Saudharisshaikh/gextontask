package com.example.gextontask.MyExternalTest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gextontask.R;

import java.util.ArrayList;

/*
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myholder> {


    Context context;
    ArrayList<TestModel> testModels ;

    public RecycleAdapter(ArrayList<TestModel> testModels) {

    this.testModels=testModels;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      */
/*  View view;
        view=(LayoutInflater.from(parent.getContext()).inflate(R.layout.testrecyclerviewlayout,parent,false));
        Myholder myholder=new Myholder(view);
        return myholder;*//*


       return new Myholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.testrecyclerviewlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {

        TestModel testModel=testModels.get(position);
    holder.name.setText(testModel.getName());
    holder.email.setText(testModel.getEmail());
    holder.phone.setText(testModel.getPhone());

    }

    @Override
    public int getItemCount() {
        testModels.size();
        return 0;
    }

    public class Myholder extends RecyclerView.ViewHolder {

        TextView name;
        TextView email;
        TextView phone;


        public Myholder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.namelayout);
            email=itemView.findViewById(R.id.emaillayout);
            phone=itemView.findViewById(R.id.phonelayout);

        }
    }
}
*/
public class RecycleAdapter extends BaseAdapter {

     Context context;
     ArrayList<TestModel> arrayList;
     LayoutInflater layoutInflater;

    public RecycleAdapter(Context context, ArrayList<TestModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater= (LayoutInflater) LayoutInflater.from(context).getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View row=view;
        Uholder uholder;
        if (view==null){

            uholder=new Uholder();
            row=layoutInflater.inflate(R.layout.testrecyclerviewlayout,viewGroup,false);

            uholder.textViewname=row.findViewById(R.id.namelayout);
            uholder.textViewemail=row.findViewById(R.id.emaillayout);
            uholder.textViewphone=row.findViewById(R.id.phonelayout);

            row.setTag(uholder);
        }
        else {

            uholder=(Uholder) row.getTag();
        }

        TestModel testModel=arrayList.get(i);

        uholder.textViewname.setText(testModel.getName());
        uholder.textViewemail.setText(testModel.getEmail());
        uholder.textViewphone.setText(testModel.getPhone());

        return row;
    }

    public static class Uholder {

        TextView textViewname;
        TextView textViewemail;
        TextView textViewphone;

    }
}