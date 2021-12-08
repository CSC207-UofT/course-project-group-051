package phase2.controllers;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import phase2.dataaccess.DataAccessInterface;
import phase2.presenters.MatchView;
import phase2.presenters.MessageView;
import phase2.presenters.View;
import phase2.usecase.MessageCase;
import phase2.users.SelfUser;

import java.util.ArrayList;

/** A controller that delegates the task for each button in the message view.
 */
public class MessageController extends Controller{


    SelfUser currentUser; // the primary user ID.
    int receiver; // the secondary user ID
    MessageCase messageCase;

    /** Creates an instance of MessageController.
     * @param db the data access interface.
     * @param stage the main stage.
     * @param currentUser the id of currentUser user.
     * @param receiver the id of receiver user.
     */
    public MessageController(DataAccessInterface db, Stage stage, SelfUser currentUser, int receiver){
        super(db, stage);
        this.currentUser = currentUser;
        this.receiver = receiver;
        messageCase = new MessageCase(db, currentUser, receiver);
    }


    /**
     * @return An EventHandler that sends a message to the receiver.
     */
    public EventHandler<ActionEvent> send(TextField msg){
        return event -> {

            messageCase.sendMessage(msg.getText());
            View view = new MessageView(receiver);
            view.build();

        };

    }


    /**
     * @return An EventHandler that returns the currentUser to the Matches screen.
     */
    public EventHandler<ActionEvent> back(){

        return event -> {
            View view = new MatchView();
            view.build();
        };
    }


    /**
     * @return A String representation of the receiver of the messages.
     */
    public String getReceiver() {

        return messageCase.getReceiverName();

    }


    /**
     * @return the messages of this thread as an ArrayList of arrays of Strings. Where each Array is a message
     * in the following format: {MessageContent, Sender, Receiver}.
     */
    public ArrayList<String[]> getThread(){
        return messageCase.getFullThread();
    }


    /**
     * Determines whether the currentUser is the sender or receiver of this message, which will determine if the
     * message displays on the left or right side of the screen.
     * @param sender the sender of this message.
     * @return The side of the messageView that the message should go as a String.
     */
    public String determineSender(String sender) {

        int senderID = Integer.parseInt(sender);

        if (senderID == currentUser.getId()) {
            return "-fx-background-color: lightblue; -fx-background-radius: 10;";
        }

        return "-fx-background-color: palegreen; -fx-background-radius: 10;";

    }
}
