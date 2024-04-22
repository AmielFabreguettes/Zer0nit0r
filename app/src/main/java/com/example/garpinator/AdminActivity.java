package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class AdminActivity extends AppCompatActivity {

    private GarpinatorRepo db;
    private RecyclerView rv;
    private UserAdminLevel user_admin_level;

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        this.prefs = getSharedPreferences("LoginActivity", Context.MODE_PRIVATE);

        this.db = new GarpinatorRepo(getApplication());
        this.rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        
        List<User> users = db.getAllUsers();
        this.user_admin_level = new UserAdminLevel(users,db,prefs);

        rv.setAdapter(user_admin_level);







    }
}