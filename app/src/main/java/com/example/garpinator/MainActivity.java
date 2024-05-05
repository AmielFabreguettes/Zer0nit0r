package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    GarpinatorRepo db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContextProvider.initialize(getApplicationContext());


        db = new GarpinatorRepo(getApplication());
        prefs = getSharedPreferences("LoginActivity", Context.MODE_PRIVATE);
        List<User> users = db.getAllUsers();
        String curUser = prefs.getString("curUser","");

        if(!curUser.equals("")){
            Intent intent = new Intent(MainActivity.this, LandingPageActivity.class);
            startActivity(intent);
        }

        Button login_button = findViewById(R.id.login);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        Button create_button = findViewById(R.id.create);
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}