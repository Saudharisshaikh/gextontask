package com.example.gextontask.Pharmacy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gextontask.R;

import java.util.ArrayList;

public class Myowncustomadapter extends BaseAdapter {

    ArrayList<Pharma> pharmaArrayList;
    LayoutInflater layoutInflater;
    Context context;

    public Myowncustomadapter(Context context,ArrayList<Pharma>pharmaArrayList) {

    this.context=context;
    this.pharmaArrayList=pharmaArrayList;

    layoutInflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pharmaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return pharmaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row=view;
        Viewholdes viewholdes;
        if (row==null){

            viewholdes=new Viewholdes();
            row=layoutInflater.inflate(R.layout.myadapterlist,null);

            viewholdes.id=row.findViewById(R.id.medicineID);
            viewholdes.name=row.findViewById(R.id.medicineName);
            viewholdes.formula=row.findViewById(R.id.medicineForm);
            viewholdes.company=row.findViewById(R.id.medicinecomp);

            row.setTag(viewholdes);
        }
        else {

            viewholdes=(Viewholdes) row.getTag();
        }

        viewholdes.id.setText(pharmaArrayList.get(position).getMedicine_id());
        viewholdes.name.setText(pharmaArrayList.get(position).getMedicine_name());
        viewholdes.formula.setText(pharmaArrayList.get(position).getMedicine_formula());
        viewholdes.company.setText(pharmaArrayList.get(position).getMedicine_company());

    return row;
    }

    public static class Viewholdes{

        TextView id;
        TextView name;
        TextView company;
        TextView formula;
    }
}
