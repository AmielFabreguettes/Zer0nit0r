package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LandingPageActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private SharedPreferences.Editor prefsEdit;

    private String curUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        this.prefs = getSharedPreferences("LoginActivity",Context.MODE_PRIVATE);
        curUser = prefs.getString("curUser","ERROR");
        prefsEdit = prefs.edit();

        TextView title = findViewById(R.id.title);
        title.setText("Welcome " + curUser + " !");
        if(prefs.getBoolean("isAdmin",false)){
            Button admin_button = findViewById(R.id.admin_button);
            admin_button.setVisibility(View.VISIBLE);
        }

        Button pirate_list_button = findViewById(R.id.pirate_list_button);

        pirate_list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPageActivity.this,PiratesListActivity.class);
                startActivity(intent);
            }
        });

        Button history_button = findViewById(R.id.history_button);

        history_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPageActivity.this,HistoryActivity.class);
                startActivity(intent);
            }
        });

        Button admin_button = findViewById(R.id.admin_button);
        admin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPageActivity.this,AdminActivity.class);
                startActivity(intent);
            }
        });

        Button logout_button = findViewById(R.id.logout_button);

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefsEdit.putString("curUser","");
                prefsEdit.apply();
                Intent intent = new Intent(LandingPageActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button start_button = findViewById(R.id.start_button);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPageActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });


    }
}