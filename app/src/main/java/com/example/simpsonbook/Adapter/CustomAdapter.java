package com.example.simpsonbook.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.simpsonbook.Model.Simpson;
import com.example.simpsonbook.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<Simpson> {

    private ArrayList<Simpson> simpsons;
    private Activity context;

    public CustomAdapter(ArrayList<Simpson> simpsons, Activity context) {

        super(context, R.layout.custom_view, simpsons);
        this.simpsons = simpsons;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view,null, true);

        TextView nameView = customView.findViewById(R.id.customTextView);
        nameView.setText(simpsons.get(position).getName());

        return customView;
    }
}
