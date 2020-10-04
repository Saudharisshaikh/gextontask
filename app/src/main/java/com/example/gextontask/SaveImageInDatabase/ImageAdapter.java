package com.example.gextontask.SaveImageInDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gextontask.R;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.Holders> {

    ArrayList<ImageModel> arrayList;

    public ImageAdapter(ArrayList<ImageModel> arrayList){

        this.arrayList=arrayList;
    }

      @NonNull
      @Override
      public Holders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         return new Holders (LayoutInflater.from(parent.getContext()).inflate(R.layout.listshow,parent,false));

      }

      @Override
      public void onBindViewHolder(@NonNull Holders holder, int position) {

        ImageModel imageModel=arrayList.get(position);
        holder.textView.setText(imageModel.imageName);
        holder.imageView.setImageBitmap(imageModel.getImage());

      }

      @Override
      public int getItemCount() {
          return arrayList.size();
      }

      public static class Holders extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
          public Holders(@NonNull View itemView) {
              super(itemView);

              textView=itemView.findViewById(R.id.recyclerviewshowname);
              imageView=itemView.findViewById(R.id.images);

          }
      }
  }
