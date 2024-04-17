package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Button create_button = findViewById(R.id.login);
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username_input = findViewById(R.id.usernameinput);
                String entered_username = username_input.getText().toString();

                EditText password1_input = findViewById(R.id.password);
                String password1 = password1_input.getText().toString();

                EditText password2_input = findViewById(R.id.confirmpassword);
                String password2 = password2_input.getText().toString();

                if(!password1.equals(password2)){
                    Toast.makeText(CreateAccountActivity.this,
                            "Your passwords must be the same", Toast.LENGTH_SHORT).show();
                }
                else{
                    User user = new User(entered_username,password1,false);
                }


            }
        });
    }
}