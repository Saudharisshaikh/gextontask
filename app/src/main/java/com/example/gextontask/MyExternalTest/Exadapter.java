package com.example.gextontask.MyExternalTest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gextontask.R;

import java.util.ArrayList;

public class Exadapter extends RecyclerView.Adapter<Exadapter.Allholder> {

    ArrayList<Exmodel> arrayList;

    public Exadapter(ArrayList<Exmodel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Allholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new Allholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.explist,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Allholder holder, int position) {

        Exmodel exmodel=arrayList.get(position);
        holder.textView.setText(exmodel.getEmail());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }




    public class Allholder extends RecyclerView.ViewHolder {

        TextView textView;

        public Allholder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.exptext);

        }
    }
}
