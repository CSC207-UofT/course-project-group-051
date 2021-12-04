package phase2.controllers;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import phase2.constants.State;
import phase2.dataaccess.DataAccessInterface;
import phase2.presenters.MatchView;
import phase2.presenters.MessageView;

/** A controller that delegates the task for each button in the message view.
 */
public class MessageController extends Controller{
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
        this.s = stage;
        State.setState(States.Messaging);
    }

    /**
     * @return the thread ID given the user.
     */
    private int getThreadID(){
        for (Integer i : db.getThreads(primaryUser)){
            String message = db.getThread(i).get(0);
            Integer puserID = new Integer(message.split(",")[1]);
            Integer suserID = new Integer(message.split(",")[2]);
            if(puserID == primaryUser && suserID == secondaryUser){
                return i;
            }
        }
        return -1;
    }

    /**
     * @return true if the user has non-empty threads, false otherwise.
     */
    private boolean hasThread(){
        if (db.getThread(primaryUser).size() == 0){
            return false;
        }
        else{
            for (Integer i : db.getThreads(primaryUser)){
                String message = db.getThread(i).get(0);
                Integer puserID = new Integer(message.split(",")[1]);
                Integer suserID = new Integer(message.split(",")[2]);
                if(puserID == primaryUser && suserID == secondaryUser){
                    return true;
                }

            }

        }
        return false;

    }

    /**
     * @return the event handler when the "Send" button is pressed.
     */

    public EventHandler<ActionEvent> send(String msg){

        EventHandler<ActionEvent> e = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (db.getThreads(primaryUser).size() > 0){
                for (Integer i: db.getThreads(primaryUser)) {
                    if (!hasThread()){
                        int threadid = db.createThread(primaryUser, secondaryUser);
                        db.createMessage(threadid, primaryUser, secondaryUser, msg);
                    }

                    else {
                        Integer threadid = new Integer(getThreadID());
                        db.createMessage(threadid, primaryUser, secondaryUser, msg);
                    }
                    MessageView m = new MessageView(db, s, primaryUser, secondaryUser);
                    m.build();
                }
                }
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
