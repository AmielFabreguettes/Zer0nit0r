package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Chracter_not_found extends AppCompatActivity {


    TextView question;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chracter_not_found);

        question = findViewById(R.id.question);
        back = findViewById(R.id.back_button);

        question.setText("Your pirate does not appear in the pirate list");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chracter_not_found.this, LandingPageActivity.class);
                startActivity(intent);
            }
        });
    }
}