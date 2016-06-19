package com.example.fmchora.androiddatastorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button advance;
    public Button save;
    public TextView counter;
    public int counterInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences countInfo = getSharedPreferences("counterInteger", 0);
        counterInt = countInfo.getInt("counterInteger", 0);

        counter = (TextView)findViewById(R.id.counter);
        advance = (Button) findViewById(R.id.advance);
        save = (Button) findViewById(R.id.save);
        counter.setText(""+counterInt);


        advance.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                counterInt++;
                counter.setText(""+counterInt);


            }
        }
        );

        save.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                SharedPreferences countInfo = getSharedPreferences("counterInteger", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = countInfo.edit();
                //edit.clear();
                edit.putInt("counterInteger", counterInt);
                edit.commit();
                Toast.makeText(MainActivity.this,"Count details are saved.." + counterInt, Toast.LENGTH_LONG).show();


            }
        }
        );
    }



}


