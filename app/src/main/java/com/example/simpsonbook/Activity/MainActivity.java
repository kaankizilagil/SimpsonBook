package com.example.simpsonbook.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.simpsonbook.Adapter.CustomAdapter;
import com.example.simpsonbook.R;
import com.example.simpsonbook.Model.Simpson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Simpson> simpsonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        Simpson character1 = new Simpson("Homer Simpson","Manager", R.drawable.image6);
        Simpson character2 = new Simpson("Bart Simpson","Student", R.drawable.image7);
        Simpson character3 = new Simpson("Marge Simpson","Housewife", R.drawable.image8);

        simpsonList = new ArrayList<>();
        simpsonList.add(character1);
        simpsonList.add(character2);
        simpsonList.add(character3);

        CustomAdapter customAdapter = new CustomAdapter(simpsonList, MainActivity.this);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Selected Simpson", simpsonList.get(i));
                startActivity(intent);
            }
        });
    }
}
