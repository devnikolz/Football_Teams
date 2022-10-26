


package com.example.peoplelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // initialise the search view
//    SearchView searchView;

    private RecyclerView recyclerView = null;
    private DataAdapter adapter = null;
    private TeamsFromXML people = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // searchView settings
//        searchView.findViewById(R.id.searchView);
//
//        // setup Listener
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                // need to filter the data
////                filter_data(newText);
//                return true;
//            }
//        });

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

    // method
//    private void filter_data(String newText) {
//        // create new list
//        List<Team> filtered_list = new ArrayList<>();
//        // create for loop to iterate through data
//        for (Team item: TeamsFromXML){
//            if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
//                // if matches add item to filtered list
//                filtered_list.add(item);
//            }
//        }
//        // send to the adapter
//        adapter.filter_list(fi);
//    }
}