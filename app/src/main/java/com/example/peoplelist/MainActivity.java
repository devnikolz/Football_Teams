


package com.example.peoplelist;

import static com.example.peoplelist.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

//    // initialise the bottom nav view bar
//    BottomNavigationView navBar;

    private RecyclerView recyclerView = null;
    private DataAdapter adapter = null;
    private TeamsFromXML people = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        // initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(id.navBar);

        // setup the navBar manu view home
        bottomNavigationView.setSelectedItemId(id.home);

        // perform listener on items
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // add switch statement
                switch (item.getItemId()) {

                    // navigate to home screen
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    // navigate to the whole different screen
                    case R.id.stats:
                        startActivity(new Intent(getApplicationContext(), Activity5.class));
                        overridePendingTransition(0, 0);
                        return true;


                    default:
                        throw new IllegalArgumentException("Unknown error");

                }

            }
        });

        // recycleView settings
        recyclerView = findViewById(id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // get the data
        people = new TeamsFromXML(this);
        Team[] teams = people.getPeople();

        // make the adapter and set it to recycleView
        adapter = new DataAdapter(this, layout.row_layout, teams);
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