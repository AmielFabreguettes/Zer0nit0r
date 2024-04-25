package com.example.garpinator;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);


    @Query("Select * from " + GarpinatorDatabase.USER_TABLE)
    List<User> getAllUsers();

    @Query("Select * from " + GarpinatorDatabase.USER_TABLE + " Where username = :username")
    User getUserByName(String username);

    @Query("Select * from " + GarpinatorDatabase.USER_TABLE + " Where id = :id")
    User getUserByID(int id);

    @Query("Delete from " + GarpinatorDatabase.USER_TABLE)
    void clearUserTable();

    @Query("Update " + GarpinatorDatabase.USER_TABLE+ " Set isAdmin = :isAdmin Where username = :username")
    void changeAdmin(String username, boolean isAdmin);

    @Query("Delete from " + GarpinatorDatabase.USER_TABLE + " Where username = :username")
    void deleteUser(String username);
}
