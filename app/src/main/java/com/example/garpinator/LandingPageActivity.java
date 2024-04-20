package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingPageActivity extends AppCompatActivity {

    private SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        this.prefs = getSharedPreferences("LoginActivity",Context.MODE_PRIVATE);
        if(prefs.getBoolean("isAdmin",false)){
            Button admin_button = findViewById(R.id.admin_button);
            admin_button.setVisibility(View.VISIBLE);
        }

        Button admin_button = findViewById(R.id.admin_button);
        admin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPageActivity.this,AdminActivity.class);
                startActivity(intent);
            }
        });

    }
}