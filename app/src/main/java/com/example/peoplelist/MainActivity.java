


package com.example.peoplelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView = null;
    private DataAdapter adapter = null;
    private TeamsFromXML people = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recycleView settings
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // get the data
        people = new TeamsFromXML(this);
        Team[] teams = people.getPeople();

        // make the adapter and set it to recycleView
        adapter = new DataAdapter(this, R.layout.row_layout, teams);
        recyclerView.setAdapter(adapter);
    }
}