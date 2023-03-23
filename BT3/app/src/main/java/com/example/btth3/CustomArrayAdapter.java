package com.example.btth3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<Country> {
    Context context;
    ArrayList<Country> arrayList;
    int layoutResource;
    public CustomArrayAdapter(Context context, int resource, ArrayList<Country> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutResource = resource;
        this.arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutResource, null);
        TextView txt1 = (TextView)convertView.findViewById(R.id.TextView);
        txt1.setText(arrayList.get(position).getName());
        TextView txt2 = (TextView)convertView.findViewById(R.id.TextView2);
        txt2.setText(arrayList.get(position).getName());
        ImageView img = (ImageView)convertView.findViewById(R.id.img);
        img.setImageResource(arrayList.get(position).getImg());

        return convertView;
    }
}
