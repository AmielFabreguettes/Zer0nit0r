package com.example.garpinator;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PirateDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPirate(Pirate pirate);

    @Query("Select * from " + GarpinatorDatabase.PIRATE_TABLE)
    List<Pirate> getAllPirates();

    @Delete
    void deletePirate(Pirate pirate);

}
