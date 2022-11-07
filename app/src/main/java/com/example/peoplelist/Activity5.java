package com.example.peoplelist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Activity5 extends AppCompatActivity {

    private TextView teamTextViewResult;
    private RequestQueue teamQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        teamTextViewResult = findViewById(R.id.fetch_result);
        Button fetchButton = findViewById(R.id.fetchButton);

        teamQueue = Volley.newRequestQueue(this);

        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamJsonParse();
            }
        });

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

    private void teamJsonParse() {

        String url = "https://api.npoint.io/fa86e2f941bea87c4e6c";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("Teams");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject team = jsonArray.getJSONObject(i);

                                String stats = team.getString("stats");

                                teamTextViewResult.append(stats + ", " + "\n\n");


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();
            }
        });

        teamQueue.add(request);
    }

}