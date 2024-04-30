package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        boolean character_found = false;
        TextView title = findViewById(R.id.question);

        // if first time
        // Ask if you know the rules
        // Then do stuff

        while (!character_found){

        }
    }
}