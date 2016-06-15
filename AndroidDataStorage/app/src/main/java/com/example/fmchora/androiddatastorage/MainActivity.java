package com.example.fmchora.androiddatastorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button advance;
    public Button save;
    public TextView counter;
    public int counterInt = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = (TextView)findViewById(R.id.counter);
        advance = (Button) findViewById(R.id.advance);
        save = (Button) findViewById(R.id.save);



        advance.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                counter.setText(""+counterInt);
                counterInt++;
            }
        }
        );

        save.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                SharedPreferences sharedpref = getSharedPreferences("counter", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpref.edit();
                
            }
        }
        );
    }



}


