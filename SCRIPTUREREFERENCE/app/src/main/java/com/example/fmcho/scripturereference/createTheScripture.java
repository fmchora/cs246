package com.example.fmcho.scripturereference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class createTheScripture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_the_scripture);

        Button shareButton = (Button) findViewById(R.id.button_share);

        assert shareButton != null;
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),displayTheScripture.class);

                final EditText editBookText = (EditText) findViewById(R.id.book_text);
                String book = editBookText.getText().toString();

                final EditText editChapterText = (EditText) findViewById(R.id.chapter_text);
                String chapter = editChapterText.getText().toString();

                final EditText editVerseText = (EditText) findViewById(R.id.verse_text);
                String verse = editVerseText.getText().toString();

                intent.putExtra("user-book", book);
                intent.putExtra("user-chapter", chapter);
                intent.putExtra("user-verse", verse);

                startActivity(intent);
            }
        });

    }
}
