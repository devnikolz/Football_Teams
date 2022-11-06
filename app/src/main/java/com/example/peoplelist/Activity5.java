package com.example.peoplelist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.navBar);

        // setup the navBar manu view home
        bottomNavigationView.setSelectedItemId(R.id.stats);

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


                    default:
                        throw new IllegalArgumentException("Unknown error");

                }

            }
        });




    }
}