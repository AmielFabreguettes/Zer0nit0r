package com.example.garpinator;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GarpinatorDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("Select * from " + GarpinatorDatabase.userTable)
    List<User> getAllUsers();

    @Query("Select * from " + GarpinatorDatabase.userTable + " Where username = :username")
    User getUserByName(String username);

    @Query("Select * from " + GarpinatorDatabase.userTable + " Where id = :id")
    User getUserByID(int id);

    @Query("Delete from " + GarpinatorDatabase.userTable)
    void clearUserTable();

    @Query("Update " + GarpinatorDatabase.userTable + " Set isAdmin = :isAdmin Where username = :username")
    void changeAdmin(String username, boolean isAdmin);

    @Query("Delete from " + GarpinatorDatabase.userTable + " Where username = :username")
    void deleteUser(String username);
}
