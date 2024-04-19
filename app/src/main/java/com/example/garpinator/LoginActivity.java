package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {


    private GarpinatorRepo db;
    private SharedPreferences prefs;
    private SharedPreferences.Editor prefsEdit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.db = new GarpinatorRepo(getApplication());
        this.prefs = getSharedPreferences("LoginActivity",Context.MODE_PRIVATE);
        this.prefsEdit = prefs.edit();

        Button sumbitButton = findViewById(R.id.login);

        sumbitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username_input = findViewById(R.id.logininput);
                String entered_username = username_input.getText().toString();

                EditText password_input = findViewById(R.id.password);
                String password = password_input.getText().toString();

                User user = db.getUserByName(entered_username);
                if(user == null || !Objects.equals(user.getPassword(), password)){
                    Toast.makeText(LoginActivity.this,
                            "Username or password incorrect.",Toast.LENGTH_SHORT).show();
                }
                else{
                    prefsEdit.putString("curUser",user.getUsername());
                    prefsEdit.putBoolean("isAdmin",user.isAdmin());
                    prefsEdit.apply();
                    Intent intent = new Intent(LoginActivity.this, LandingPageActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}