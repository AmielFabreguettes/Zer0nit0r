package com.example.garpinator;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertHistory(History history);

    @Query("Select * from " + GarpinatorDatabase.HISTORY_TABLE)
    List<History> getHistory();
}
