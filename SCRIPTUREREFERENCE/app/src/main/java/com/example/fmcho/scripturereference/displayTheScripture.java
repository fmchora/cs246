package com.example.fmcho.scripturereference;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.TextView;

public class displayTheScripture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_the_scripture);
        String book = getIntent().getStringExtra("user-book");
        String chapter = getIntent().getStringExtra("user-chapter");
        String verse = getIntent().getStringExtra("user-verse");

        TextView scripture = (TextView)findViewById(R.id.displayScripture);


        scripture.setText("Your Favorite Scripture is: " + book + " " + chapter
         + ":" + verse);
    }
}
