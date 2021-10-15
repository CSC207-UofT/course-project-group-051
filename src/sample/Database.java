package sample;

import java.util.ArrayList;

public class Database {
    private ArrayList<User> iter;
    public Database(){
    this.iter = new ArrayList<>();
    };
    public Boolean contains(User u){
        return this.iter.contains(u);
    }
    public void add(User u){
        this.iter.add(u);
    }

    }

