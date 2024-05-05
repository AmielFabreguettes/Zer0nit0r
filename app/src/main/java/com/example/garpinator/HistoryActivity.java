package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    GarpinatorRepo db;
    RecyclerView rv;

    HistoryListObject history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        this.db = new GarpinatorRepo(getApplication());
        this.rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));


        List<History> histories = db.getHistory();
        this.history = new HistoryListObject(histories,db);

        rv.setAdapter(history);

    }
}