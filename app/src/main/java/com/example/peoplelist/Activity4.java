package com.example.peoplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    WebView teamwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // get the team object
        Team t = (Team) getIntent().getExtras().getSerializable("team_name");
        t.getUrl();


        teamwebView = findViewById(R.id.teamWebView);
        teamwebView.loadUrl(t.getUrl());

    }

}