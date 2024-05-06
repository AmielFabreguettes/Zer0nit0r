package com.example.garpinator;

import android.app.Application;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class GarpinatorRepo {
    private UserDAO userDAO;
    private PirateDAO pirateDAO;
    private HistoryDAO historyDAO;

    public GarpinatorRepo(Application app){
        GarpinatorDatabase db = GarpinatorDatabase.getDatabase(app);
        this.userDAO = db.UserDAO();
        this.pirateDAO = db.PirateDAO();
        this.historyDAO = db.HistoryDAO();
    }

    public List<User> getAllUsers() {
        Future<List<User>> future = GarpinatorDatabase.databaseWriteExecutor.submit(
                new Callable<List<User>>() {
                    @Override
                    public List<User> call() throws Exception {
                        return userDAO.getAllUsers();
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

    public List<Pirate> getAllPirates() {
        Future<List<Pirate>> future = GarpinatorDatabase.databaseWriteExecutor.submit(
                new Callable<List<Pirate>>() {
                    @Override
                    public List<Pirate> call() throws Exception {
                        return pirateDAO.getAllPirates();
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

    public List<History> getHistory() {
        Future<List<History>> future = GarpinatorDatabase.databaseWriteExecutor.submit(
                new Callable<List<History>>() {
                    @Override
                    public List<History> call() throws Exception {
                        return historyDAO.getHistory();
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
            userDAO.insertUser(user);
        });
    }

    public void insertHistory(History histo){
        GarpinatorDatabase.databaseWriteExecutor.execute(() ->{
            historyDAO.insertHistory(histo);
        });
    }

    public void clearUserTable(){
        GarpinatorDatabase.databaseWriteExecutor.execute(() ->
                userDAO.clearUserTable());
    }

    public void changeAdmin(String username, boolean isAdmin){
        GarpinatorDatabase.databaseWriteExecutor.execute(() ->
                userDAO.changeAdmin(username,isAdmin));
    }

    public void deleteUser(String username){
        GarpinatorDatabase.databaseWriteExecutor.execute(() ->
                userDAO.deleteUser(username));
    }

    public User getUserByName(String name){
        Future<User> user = GarpinatorDatabase.databaseWriteExecutor.submit(
                new Callable<User>(){
                    @Override
                    public User call() throws Exception{
                        return userDAO.getUserByName(name);
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

    public User getUserById(int id){
        Future<User> user = GarpinatorDatabase.databaseWriteExecutor.submit(
                new Callable<User>(){
                    @Override
                    public User call() throws Exception{
                        return userDAO.getUserByID(id);
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

    public Pirate getPirateById(int id){
        Future<Pirate> user = GarpinatorDatabase.databaseWriteExecutor.submit(
                new Callable<Pirate>(){
                    @Override
                    public Pirate call() throws Exception{
                        return pirateDAO.getPirateById(id);
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

    public Pirate getPirateByName(String name){
        Future<Pirate> user = GarpinatorDatabase.databaseWriteExecutor.submit(
                new Callable<Pirate>(){
                    @Override
                    public Pirate call() throws Exception{
                        return pirateDAO.getPirateByName(name);
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
