package com.example.garpinator;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = GarpinatorDatabase.PIRATE_TABLE)
public class Pirate {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    private int odds;

    public Pirate(String name) {
        this.name = name;
        this.odds = 2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOdds() {
        return odds;
    }

    public void setOdds(int odds) {
        this.odds = odds;
    }
}
