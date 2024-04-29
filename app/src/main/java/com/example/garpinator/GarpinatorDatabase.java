package com.example.garpinator;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class,Pirate.class},version = 9,exportSchema = false)
public abstract class GarpinatorDatabase extends RoomDatabase {


    public static final String DB_NAME = "GarpinatorDB";
    public static final String USER_TABLE = "userTable";
    public static final String PIRATE_TABLE = "pirateTable";
    public static final String HISTORY_TABLE = "historyTable";

    private static final String PIRATES_XML_FILE = "pirates.xml";

    private static volatile GarpinatorDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);




    public static GarpinatorDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (GarpinatorDatabase.class){
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    GarpinatorDatabase.class, DB_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(addDefaultValues)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                User admin = new User("admin2","admin2",true);
                INSTANCE.UserDAO().insertUser(admin);

                User testuser = new User("testuser1","testuser1",false);
                INSTANCE.UserDAO().insertUser(testuser);

                List<Pirate> pirates = retrieveAllPirates();
                if(pirates != null) {
                    for (Pirate p : pirates) {
                        INSTANCE.PirateDAO().insertPirate(p);
                    }
                }
            });
        }
    };

    public static List<Pirate> retrieveAllPirates(){
        Context ct = ContextProvider.getContext();
        List<String> names = RecordsXMLParser.parseRecords(ct,R.xml.pirates);
        List<Pirate> result = new ArrayList<>();
        for(String n: names){
            Pirate p = new Pirate(n);
            result.add(p);
        }
        return result;
    }

    public abstract UserDAO UserDAO();
    public abstract PirateDAO PirateDAO();

    public abstract HistoryDAO HistoryDAO();
}
