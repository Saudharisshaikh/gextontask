package com.example.gextontask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    ArrayList <User> users=new ArrayList();

    Context mcontext;
    LayoutInflater layoutInflater;

    public CustomAdapter(Context context,ArrayList <User>users) {

        mcontext=context;
        this.users=users;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View row=view;
        viewHolder Holder;
        final int postion=i;

        if(row==null){

            Holder=new viewHolder();
            row=layoutInflater.inflate(R.layout.listviewlayout,null);


            Holder.id=row.findViewById(R.id.id);
            Holder.name=row.findViewById(R.id.tvname);
            Holder.mail=row.findViewById(R.id.tvmailid);
            Holder.phone=row.findViewById(R.id.tvphone);

            row.setTag(Holder);

        }
        else {

            Holder=(viewHolder) row.getTag();
        }


        Holder.id.setText(users.get(postion).getId());
        Holder.name.setText(users.get(postion).name);
        Holder.mail.setText(users.get(postion).getEmail());
        Holder.phone.setText(users.get(postion).getPhone());




        return row;
    }


    public static class viewHolder {
        TextView id;
        TextView name;
        TextView mail;
        TextView phone;
    }
}
