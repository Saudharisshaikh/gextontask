package com.example.gextontask.Pharmacy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gextontask.R;

import java.util.ArrayList;
import java.util.List;

public class Adapters extends ArrayAdapter {

    List list=new ArrayList<>();

    public Adapters(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);

        list.add( object);
    }

    @Override
    public int getCount() {
        return list.size();

    }

    @Nullable
    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row=convertView;
        ViewHolders viewHolders;
         if (row==null){

             viewHolders=new ViewHolders();
             LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.myadapterlist,null);

            viewHolders.id=row.findViewById(R.id.medicineID);
            viewHolders.name=row.findViewById(R.id.medicineName);
            viewHolders.formula=row.findViewById(R.id.medicineForm);
            viewHolders.company=row.findViewById(R.id.medicinecomp);

            row.setTag(viewHolders);
         }
         else {

             viewHolders=(ViewHolders) row.getTag();
         }

         Pharma pha=(Pharma) getItem(position);

         viewHolders.id.setText(pha.getMedicine_id());
        viewHolders.name.setText(pha.getMedicine_name());
        viewHolders.formula.setText(pha.getMedicine_formula());
        viewHolders.company.setText(pha.getMedicine_company());

        return row;
    }

    public static class ViewHolders{

        TextView id;
        TextView name;
        TextView formula;
        TextView company;
    }
}
