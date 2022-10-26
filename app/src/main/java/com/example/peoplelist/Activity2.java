package com.example.peoplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private Button buttonNext;

    // create and add the objects
    ImageView imageView2;
    TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle b = getIntent().getExtras();
        Team t = (Team) b.getSerializable("team_name");

        buttonNext =findViewById(R.id.buttonInfo);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity2.this, Activity3.class);
                intent.putExtra("team_name", t);
                startActivity(intent);
            }
        });

        imageView2 = findViewById(R.id.imageView2);
        textView2 = findViewById(R.id.textView2);

        textView2.setText(t.getName());
        Integer id = Activity2.this.getResources().getIdentifier(t.getImage(), "drawable", Activity2.this.getPackageName());
        imageView2.setImageResource(id);

    }
}