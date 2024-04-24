package com.example.garpinator;

import android.app.Application;

import androidx.room.Insert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class GarpinatorRepo {
    private GarpinatorDAO garpinatorDAO;

    public GarpinatorRepo(Application app){
        GarpinatorDatabase db = GarpinatorDatabase.getDatabase(app);
        this.garpinatorDAO = db.garpinatorDAO();
    }

    public List<User> getAllUsers() {
        Future<List<User>> future = GarpinatorDatabase.databaseWriteExecutor.submit(
                new Callable<List<User>>() {
                    @Override
                    public List<User> call() throws Exception {
                        return garpinatorDAO.getAllUsers();
                    }
                }
        );

        try{
            return future.get();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void insertUser(User user){
        GarpinatorDatabase.databaseWriteExecutor.execute(() ->{
            garpinatorDAO.insert(user);
        });
    }

    public void clearUserTable(){
        GarpinatorDatabase.databaseWriteExecutor.execute(() ->
                garpinatorDAO.clearUserTable());
    }

    public void changeAdmin(String username, boolean isAdmin){
        GarpinatorDatabase.databaseWriteExecutor.execute(() ->
                garpinatorDAO.changeAdmin(username,isAdmin));
    }

    public void deleteUser(String username){
        GarpinatorDatabase.databaseWriteExecutor.execute(() ->
                garpinatorDAO.deleteUser(username));
    }

    public User getUserByName(String name){
        Future<User> user = GarpinatorDatabase.databaseWriteExecutor.submit(
                new Callable<User>(){
                    @Override
                    public User call() throws Exception{
                        return garpinatorDAO.getUserByName(name);
                    }
                }
        );
        try{
            return user.get();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
