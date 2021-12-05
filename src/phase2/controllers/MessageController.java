package phase2.controllers;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import phase2.constants.State;
import phase2.constants.States;
import phase2.dataaccess.DataAccessInterface;
import phase2.presenters.MatchView;
import phase2.presenters.MessageView;
import phase2.usecase.MessageCase;

/** A controller that delegates the task for each button in the message view.
 */
public class MessageController extends Controller{
    DataAccessInterface db; // the data access interface.
    Stage s; // the main stage.
    int primaryUser; // the primary user ID.
    int secondaryUser; // the secondary user ID
    MessageCase messageCase;

    /** Creates an instance of MessageController.
     * @param db the data access interface.
     * @param stage the main stage.
     * @param primary the id of primary user.
     * @param secondary the id of secondary user.
     */
    public MessageController(DataAccessInterface db, Stage stage, int primary, int secondary){
        super(stage, db);
        this.primaryUser = primary;
        this.secondaryUser = secondary;
        State.setState(States.MESSAGING);
        messageCase = new MessageCase(primary, secondary, db);
    }

    /**
     * @return the event handler when the "Send" button is pressed.
     */

    public EventHandler<ActionEvent> send(String msg){
        return event -> {
            messageCase.CreateMessage(msg);
            MessageView m = new MessageView(db, s, primaryUser, secondaryUser);
            m.build();
        };

    }
    /**
     * @return the event handler when the "Back" button is pressed.
     */
    public EventHandler<ActionEvent> back(){

        return event -> {
            MatchView mb = new MatchView(db, s, primaryUser);
            mb.build();
        };
    }

}
