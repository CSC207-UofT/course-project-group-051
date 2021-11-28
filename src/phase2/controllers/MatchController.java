package phase2.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import phase2.dataaccess.DataAccessInterface;

import java.util.ArrayList;

public class MatchController {
    DataAccessInterface db;
    Stage stage;
    int userID;
    EventHandler<ActionEvent> event;

    public MatchController(DataAccessInterface db, Stage stage, int userID){
        this.db = db;
        this.stage = stage;
        this.userID = userID;
    }

    public ArrayList<Integer> getMatches(){
        return db.getMatches(userID);
    }
    public String getFirstName(Integer userID){

        return null;
    }
    public EventHandler<ActionEvent> switchMessage(Integer userID){
        event = e -> {
            //TODO
        };
        return event;
    }
    public EventHandler<ActionEvent> back(){
        event = e -> {
            //TODO
        };
        return event;
    }
}
