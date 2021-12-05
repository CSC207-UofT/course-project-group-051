package phase2.controllers;

import javafx.stage.Stage;
import phase2.constants.State;
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
     * @param user1 the primary user.
     * @param swipelist the swipelist.
     * @param user2 the secondary user.
     * @param inputs the mapping of inputs to the textfield for profileView.
     * @return the controller for the next state.
     */

    int user1;
    int user2;
    HashMap registrationInputs;
    DataAccessInterface db;
    Stage stage;

    /** Creates an instance of MainController.
     * @param db the data access interface.
     * @param stage stage the main stage.
     */
    public MainController(DataAccessInterface db, Stage stage){
        this.db = db;
        this.stage = stage;

    }

    /**
     * Sets the primary user.
     * @param id the primary user's ID.
     */
    public void setPrimaryUser(int id){
        this.user1 = id;
    }

    /**
     * Sets the secondary user.
     * @param id the secondary user's ID.
     */
    public void setSecondaryUser(int id){
        this.user2 = id;
    }

    /**
     * Sets the HashMap for the registration inputs.
     * @param inputs the inputs from the Registration view.
     */
    public void setSecondaryUser(HashMap inputs){
        this.registrationInputs = inputs;
    }


    /**
     * @param action A command taken by the user.
     * @return the appropriate controller for the given state.
     */
    public Controller getController(Command action){
        if (State.getState().equals(States.LoggedIn) && action.equals(Actions.LogOut)){
        return new LogInController(db, stage);}
        else if (State.getState().equals(States.LoggedIn) && action.equals(Actions.Matches)){
            return new MatchController(db, stage, user);
        }
        else if (State.getState().equals(States.LoggedIn) && action.equals(Actions.SelfProfile)){
            return new ProfileController(db, stage, user);
        }
        else if (State.getState().equals(States.LoggedIn) && (action.equals(Actions.SwipeLeft || Actions.SwipeRight))){
            return new SwipeController(db, stage, id, swipelist);}

        else if (State.getState().equals(States.Matches) && action.equals(Actions.Message)){
            return new MessageController(db, stage, user, user2);

            }
        else if (State.getState().equals(States.SelfProfile) && action.equals(Actions.Back)){
            return new SwipeController(db, stage, user, swipelist);
            }

        else if (State.getState().equals(States.Matches) && action.equals(Actions.Back)){
            return new SwipeController(db, stage, user, swipelist);
        }
        else if (State.getState().equals(States.Messaging) && action.equals(Actions.Back)){
            return new MatchController(db, stage, user);
        }
        else if (State.getState().equals(States.Registration) && action.equals(Actions.LogIn)){
            return new LogInController(db, stage);
        }

        else if (State.getState().equals(States.LoggedOut) && action.equals(Actions.LogIn)){
            return new SwipeController(db, stage, user, swipelist);
        }

        else if (State.getState().equals(States.LoggedOut) && action.equals(Actions.CreateAccount)){
            return new RegistrationController(db, stage, inputs);
        }


        return new SwipeController(db, stage, user, swipelist);


        }
    }
}
