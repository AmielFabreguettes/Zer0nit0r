package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Charcter_found extends AppCompatActivity {

    TextView question;
    Button back;

    GarpinatorRepo db;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charcter_found);
        db = new GarpinatorRepo(getApplication());
        prefs = getSharedPreferences("LoginActivity",MODE_PRIVATE);

        Intent intent = getIntent();
        String message = intent.getStringExtra("pirates");


        question = findViewById(R.id.question);
        back = findViewById(R.id.back_button);

        question.setText("Your character is " + message);
        History h = new History(db.getUserByName(prefs.getString("curUser","")),
                db.getPirateByName(message));
        db.insertHistory(h);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Charcter_found.this, LandingPageActivity.class);
                startActivity(intent);
            }
        });
    }
}