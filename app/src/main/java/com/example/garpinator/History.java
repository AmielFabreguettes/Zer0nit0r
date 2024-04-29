package com.example.garpinator;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = GarpinatorDatabase.HISTORY_TABLE)
public class History {

    @PrimaryKey(autoGenerate = true)
    int id;
    User user;
    Pirate pirate;

    public History(User user, Pirate pirate) {
        this.user = user;
        this.pirate = pirate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pirate getPirate() {
        return pirate;
    }

    public void setPirate(Pirate pirate) {
        this.pirate = pirate;
    }
}
