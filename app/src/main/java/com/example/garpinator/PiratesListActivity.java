package com.example.garpinator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class PiratesListActivity extends AppCompatActivity {

    GarpinatorRepo db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pirates_list);

        this.db = new GarpinatorRepo(getApplication());

        List<Pirate> pirates = GarpinatorDatabase.retrieveAllPirates();

        StringBuilder temp = new StringBuilder();
        for(Pirate p: pirates){
            temp.append(p.getName()).append("\n");
        }

        TextView l = findViewById(R.id.pList);
        l.setText(temp.toString());




    }
}