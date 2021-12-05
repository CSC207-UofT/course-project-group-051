package phase2.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import phase2.constants.State;
import phase2.dataaccess.DataAccessInterface;
import phase2.presenters.MessageView;
import phase2.presenters.MatchView;
import phase2.presenters.SwipeView;
import java.util.ArrayList;

public class MatchController implements Controller{
    DataAccessInterface db;
    Stage stage;
    int userID;
    EventHandler<ActionEvent> event;

    public MatchController(DataAccessInterface db, Stage stage, int userID){
        this.db = db;
        this.stage = stage;
        this.userID = userID;
        State.setState(States.Matches);
    }

    public ArrayList<Integer> getMatches(){
        return db.getMatches(userID);
    }

    public String getFirstName(Integer userID){

        return null;
    }
    public EventHandler<ActionEvent> switchMessageView(Integer userID, Integer receiverID){
        event = e -> {
            for (Integer id : getMatches()) {
                if (id.equals(receiverID)) {
                    MessageView m = new MessageView(db, stage, userID, receiverID);
                    m.build();
                }
            }
        };
        return event;
    }
    public EventHandler<ActionEvent> back() {
        event = e -> {
            SwipeView s = new SwipeView(db, stage, userID, db.getSwipeList(userID));
            s.build();
        };
        return event;
    }
}
