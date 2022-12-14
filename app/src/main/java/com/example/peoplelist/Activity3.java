package com.example.peoplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Activity3 extends AppCompatActivity {

    ProgressBar progressBar;
    int counter = 0;

    private Button buttonNext;



    // create and add the objects
    TextView textView4, textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        progressLoad();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonNext =findViewById(R.id.buttonLink);

        Bundle b = getIntent().getExtras();
        Team t = (Team) b.getSerializable("team_name");

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity3.this, Activity4.class);
                intent.putExtra("team_name", t);
                startActivity(intent);
            }
        });

        textView4 = findViewById(R.id.textView4);
        textView4.setText(t.getHistory());

        textView5 = findViewById(R.id.textView5);
        textView5.setText(t.getOwner());

    }

    public void progressLoad() {
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter ++;
                progressBar.setProgress(counter);

                if (counter == 100)
                    t.cancel();
            }
        };

        t.schedule(tt, 0, 5);
    }
}