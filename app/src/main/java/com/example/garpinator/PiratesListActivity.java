package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class PiratesListActivity extends AppCompatActivity {

    GarpinatorRepo db;
    RecyclerView rv;
    PirateListObject plist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pirates_list);

        this.db = new GarpinatorRepo(getApplication());
        this.rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));


        List<Pirate> pirates = db.getAllPirates();
        this.plist = new PirateListObject(pirates,db);

        rv.setAdapter(plist);

    }
}