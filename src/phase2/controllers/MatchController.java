package phase2.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import phase2.dataaccess.DataAccessInterface;
import phase2.presenters.MessageView;
import phase2.presenters.SwipeView;
import phase2.presenters.View;
import phase2.usecase.MatchCase;
import phase2.users.SelfUser;

import java.util.Map;

/**
 * Defines the buttons needed for the Matches screen.
 */
public class MatchController extends Controller{


    EventHandler<ActionEvent> event;
    final MatchCase matchCase;

    /**
     * @param db A reference to our Database.
     * @param stage A reference to the stage, so we can display things.
     * @param currentUser the ID of the currentUser.
     */
    public MatchController(DataAccessInterface db, Stage stage, SelfUser currentUser){
        super(db, stage);
        matchCase = new MatchCase(db, currentUser);
    }


    /**
     * @param receiverID the ID of the user who you want to message.
     * @return an EventHandler that switches to MessageView and allows messaging of the receiver.
     */
    public EventHandler<ActionEvent> switchMessageView(Integer receiverID){
        event = e -> {

            View view = new MessageView(receiverID);
            view.build();

        };
        return event;
    }

    /**
     * @return an EventHandler that brings the program back to the swiping screen.
     */
    public EventHandler<ActionEvent> back() {
        event = e -> {
            View view = new SwipeView();
            view.build();
        };
        return event;
    }

    /**
     * @return A map in the form <User's name, User's Id> where each User has matched with the currentUser.
     */
    public Map<String, Integer> getMatches(){
        return matchCase.getMatches();
    }

}
