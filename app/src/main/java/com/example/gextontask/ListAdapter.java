package com.example.gextontask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListAdapter extends ArrayAdapter {

    List arraylist =new ArrayList();

    public int time=0;
    public ListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        arraylist.add(object);
    }

    @Nullable
    @Override
    public Object getItem(int position) {

        return arraylist.get(position);
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row =convertView;
        Viewholder viewholder;

        if(row==null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.listviewlayout,null);
            viewholder = new Viewholder();

            viewholder.id=row.findViewById(R.id.id);
            viewholder.name = row.findViewById(R.id.tvname);
            viewholder.email = row.findViewById(R.id.tvmailid);
            viewholder.phone = row.findViewById(R.id.tvphone);

            row.setTag(viewholder);
        time++;
        }
        else {

            viewholder=(Viewholder)row.getTag();
        }

        User user=(User)getItem(position);

        viewholder.id.setText(user.getId());
        viewholder.name.setText(user.getName());
        viewholder.email.setText(user.getEmail());
        viewholder.phone.setText(user.getPhone());

        return row;
    }

   public static class Viewholder{


        public TextView id;
     public    TextView name;
     public    TextView email;
    public     TextView phone;
    }


}
