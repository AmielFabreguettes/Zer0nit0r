package com.example.garpinator;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class GarpinatorDatabase extends RoomDatabase {

    public static final String userTable = "userTable";
}
