package phase2.controllers;
import Phase1.Views.MatchesViewBuilder;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import phase2.dataaccess.DataAccessInterface;
import phase2.presenters.MatchView;
import phase2.presenters.MessageView;

import java.util.ArrayList;

/** A controller that delegates the task for each button in the message view.
 */
public class MessageController {
    DataAccessInterface db; // the data access interface.
    Stage s; // the main stage.
    int primaryUser; // the primary user ID.
    int secondaryUser; // the secondary user ID

    /** Creates an instance of MessageController.
     * @param db the data access interface.
     * @param stage the main stage.
     * @param primary the id of primary user.
     * @param secondary the id of secondary user.
     */
    public MessageController(DataAccessInterface db, Stage stage, int primary, int secondary){
        this.db = db;
        this.primaryUser = primary;
        this.secondaryUser = secondary;
        this.s = s;
    }

    /**
     * @return the event handler when the "Send" button is pressed.
     */
    public EventHandler<ActionEvent> send(Thread thread){

        EventHandler<ActionEvent> e = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                db.addThread(thread);
                ArrayList t = new ArrayList();
                ArrayList threads = db.getThreads(primaryUser);
                for (Thread i: threads){
                    if (i.primaryUser.equals(primaryUser) && i.secondaryUser.equals(secondaryUser)){
                        t.add(i);
                    }
                }
                MessageView m = new MessageView(db, s, primaryUser, secondaryUser);
                m.build();
            }
        };

        return e;

    }
    /**
     * @return the event handler when the "Back" button is pressed.
     */
    public EventHandler<ActionEvent> back(){
        EventHandler e = new EventHandler() {
            @Override
            public void handle(Event event) {
                MatchView mb = new MatchView(db, s, primaryUser);
                mb.build();
            }
        };

        return e;
    }

}
