package com.example.garpinator;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class GarpinatorDatabase extends RoomDatabase {

    public static final String userTable = "userTable";

    private static volatile GarpinatorDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

}
