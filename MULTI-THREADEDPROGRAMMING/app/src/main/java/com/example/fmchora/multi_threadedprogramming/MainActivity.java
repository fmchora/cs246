package com.example.fmchora.multi_threadedprogramming;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ProgressBar progressBar;
    private Button buttonCreate;
    private Button buttonLoad;
    private Button buttonClear;
    private TextView textViewtoShow;
    private ListView listviewtoDisplay;
    private ArrayAdapter<String> adapter;
    private String[] stockArr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCreate = (Button) findViewById(R.id.buttonCreate);
        buttonLoad = (Button) findViewById(R.id.buttonLoad);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(0);


        buttonCreate.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){

                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        createFile();

                    }
                };
                Thread createFile = new Thread(r);
                createFile.start();

                int time = 100;
                int timetowait = 100;
                try {
                    int timeprogres = 0;
                    while( timeprogres < time) {
                        progressBar.setProgress(timeprogres);
                        Thread.sleep(timetowait);
                        timeprogres+= 5;

                    }
                    Toast.makeText(getApplicationContext(),"File created",Toast.LENGTH_LONG).show();
                    Thread.sleep(200);
                    progressBar.setVisibility(View.GONE);

                }
                catch (InterruptedException ex) { android.util.Log.d("YourApplicationName", ex.toString()); }


            }
        }
     );


        buttonLoad.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                Runnable rc = new Runnable() {
                    @Override
                    public void run() {
                        long time = 4000;
                        try {
                            Thread.sleep(time);
                             //handler.sendEmptyMessage(0);
                        }
                        catch (InterruptedException ex) { android.util.Log.d("YourApplicationName", ex.toString()); }
                    }
                };
                Thread threadLoadFile = new Thread(rc);
                threadLoadFile.start();
                loadFile();

                //Toast.makeText(getApplicationContext(),"File Loaded",Toast.LENGTH_LONG).show();

            }
        }
        );




        buttonClear.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                Runnable rc = new Runnable() {
                    @Override public void run() {

                    }
                };
                Thread threadLoadFile = new Thread(rc);
                threadLoadFile.start();
                progressBar.setVisibility(View.VISIBLE);
                adapter.clear();
                long miliseconds = 10;
                for(int j = 0; j < 100; j++){
                    progressBar.setProgress(j);
                    try {
                        Thread.sleep(miliseconds);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        );
    }


    public void createFile(){

        String filename = "myfile";

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename,MODE_PRIVATE);
            String numbers = "";
            for(int i =1; i <=10; i++) {
                numbers = Integer.toString(i) + "\n";
                outputStream.write(numbers.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void loadFile(){
        String message;
        List<String> savenumbers = new ArrayList<String>();

        try {
            FileInputStream fileInputStream = openFileInput("myfile");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while((message = bufferedReader.readLine()) != null){
                savenumbers.add( message);
            }


            String[] array = new String[savenumbers.size()];


            listviewtoDisplay =(ListView) findViewById(R.id.listViewmain);
            adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,savenumbers);
            listviewtoDisplay.setAdapter(adapter);

        }catch (FileNotFoundException e){
            e.printStackTrace();} catch (IOException e) {
            e.printStackTrace();
        }

    }


}


