package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class AdminActivity extends AppCompatActivity {

    private GarpinatorRepo db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        this.db = new GarpinatorRepo(getApplication());
        StringBuilder list = new StringBuilder();

        List<User> users = db.getAllUsers();
        for(User u: users){
            list.append(u.getUsername()).append("\n");
        }

        TextView user_list = findViewById(R.id.listUser);
        user_list.setText(list.toString());
    }
}