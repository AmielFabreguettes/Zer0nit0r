package com.example.garpinator;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = GarpinatorDatabase.HISTORY_TABLE, foreignKeys = {
        @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "user",
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Pirate.class,
                parentColumns = "id",
                childColumns = "pirate",
                onDelete = ForeignKey.CASCADE)})

public class History {

    @PrimaryKey(autoGenerate = true)
    int id;
    int user;
    int pirate;

    public History(User user, Pirate pirate) {
        this.user = user.getId();
        this.pirate = pirate.getId();
    }

    public History(int user, int pirate) {
        this.user = user;
        this.pirate = pirate;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getPirate() {
        return pirate;
    }

    public void setPirate(int pirate) {
        this.pirate = pirate;
    }
}
