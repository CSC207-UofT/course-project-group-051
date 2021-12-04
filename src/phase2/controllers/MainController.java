package phase2.controllers;

import javafx.stage.Stage;
import phase2.dataaccess.DataAccessInterface;
import phase2.usecase.Command;

import java.util.HashMap;
import java.util.Queue;

/**
 * The controller that that delegates tasks given
 */
public class MainController {

    /**
     * Creates a MainController object.
     * @param state the state which the program is currently in.
     * @param action the user's input action.
     * @param db the data access interface.
     * @param stage the main stage.
     * @param user the primary user.
     * @param swipelist the swipelist.
     * @param user2 the secondary user.
     * @param inputs the mapping of inputs to the textfield for profileView.
     * @return the controller for the next state.
     */

    public MessageController(DataAccessInterface db, Stage stage){
        this.db = db;
        this.stage = stage;

    }
    public Controller getController(Command action, DataAccessInterface db, Stage stage, int user,
                                    Queue swipelist, int user2, HashMap inputs){
        if (state.equals(States.LoggedIn) && action.equals(Actions.LogOut)){
        return new LogInController(db, stage);}
        else if (state.equals(States.LoggedIn) && action.equals(Actions.Matches)){
            return new MatchController(db, stage, user);
        }
        else if (state.equals(States.LoggedIn) && action.equals(Actions.SelfProfile)){
            return new ProfileController(db, stage, user);
        }
        else if (state.equals(States.LoggedIn) && (action.equals(Actions.SwipeLeft || Actions.SwipeRight))){
            return new SwipeController(db, stage, id, swipelist);}

        else if (state.equals(States.Matches) && action.equals(Actions.Message)){
            return new MessageController(db, stage, user, user2);

            }
        else if (state.equals(States.SelfProfile) && action.equals(Actions.Back)){
            return new SwipeController(db, stage, user, swipelist);
            }

        else if (state.equals(States.Matches) && action.equals(Actions.Back)){
            return new SwipeController(db, stage, user, swipelist);
        }
        else if (state.equals(States.Messaging) && action.equals(Actions.Back)){
            return new MatchController(db, stage, user);
        }
        else if (state.equals(States.Registration) && action.equals(Actions.LogIn)){
            return new LogInController(db, stage);
        }

        else if (state.equals(States.LoggedOut) && action.equals(Actions.LogIn)){
            return new SwipeController(db, stage, user, swipelist);
        }

        else if (state.equals(States.LoggedOut) && action.equals(Actions.CreateAccount)){
            return new RegistrationController(db, stage, inputs);
        }


        return new SwipeController(db, stage, user, swipelist);


        }
    }
}
