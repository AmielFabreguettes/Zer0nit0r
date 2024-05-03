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

@Database(entities = {User.class,Pirate.class},version = 11,exportSchema = false)
public abstract class GarpinatorDatabase extends RoomDatabase {


    public static final String DB_NAME = "GarpinatorDB";
    public static final String USER_TABLE = "userTable";
    public static final String PIRATE_TABLE = "pirateTable";

    private static final String PIRATES_XML_FILE = "pirates.xml";

    public static final String HISTORY_TABLE = "historyTable";

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
        List<String> lis = RecordsXMLParser.parseRecords(ct,R.xml.pirates);
        List<Pirate> result = new ArrayList<>();
        for(int i = 0; i < lis.size(); i += 20){
            String name = lis.get(i);
            String crew = lis.get(i + 1);
            boolean gender = lis.get(i + 2).equals("1");

            String cleaned = lis.get(i + 3);
            long bounty = Long.parseLong(cleaned.replaceAll(",", ""));

            boolean nickname = lis.get(i + 4).equals("1");
            boolean status = lis.get(i + 5).equals("1");
            int age = Integer.parseInt(lis.get(i + 6));
            String birthday = lis.get(i + 7);
            int height = Integer.parseInt(lis.get(i + 8));
            boolean devil_fruit = lis.get(i + 9).equals("1");
            boolean yonko_crew = lis.get(i + 10).equals("1");
            boolean yonko = lis.get(i + 11).equals("1");
            boolean scar = lis.get(i + 12).equals("1");
            String weapon = lis.get(i + 13);
            String race = lis.get(i + 14);
            boolean captain = lis.get(i + 15).equals("1");
            boolean vsLuffy = lis.get(i + 16).equals("1");
            boolean vsZoro = lis.get(i + 17).equals("1");
            boolean vsSanji = lis.get(i + 18).equals("1");
            boolean haki = lis.get(i + 19).equals("1");
            Pirate p = new Pirate(name, crew, bounty, nickname, status, age, birthday, height, devil_fruit, yonko_crew,
                    yonko, scar, weapon, race, captain, vsLuffy, vsZoro, vsSanji, haki);
            result.add(p);
        }
        System.out.println(result.size());
        return result;
    }

    public abstract UserDAO UserDAO();
    public abstract PirateDAO PirateDAO();
}
