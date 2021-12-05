package phase2.controllers;

import javafx.stage.Stage;
import phase2.constants.State;
import phase2.dataaccess.DataAccessInterface;

import java.util.HashMap;
import java.util.Queue;

/**
 * The controller that that delegates tasks given
 */
public class MainController extends Controller{

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
    Queue<Integer> swipeList;

    /** Creates an instance of MainController.
     * @param db the data access interface.
     * @param stage stage the main stage.
     */
    public MainController(DataAccessInterface db, Stage stage){
        super(stage, db);

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
    public Controller getController(String transition){
        String state = State.getState();
        if(transition.equals(States.BACK)) {
            if(state.equals(States.MESSAGING)){
                return new MatchController(db, stage, user);
            }
            else if(state.equals(States.PROFILE) || state.equals(States.MATCHES)){
                return new SwipeController(db, stage, user, swipelist);
            }
            else if(state.equals(States.REGISTRATION)){
                return new LogInController(db, stage);
            }
        }
        else if(state.equals(States.SWIPING)){
            if(transition.equals(States.LOGGED_OUT)){
                return new LogInController(db, stage);
            }
            else if(transition.equals(States.MATCHES)){
                return new MatchController(db, stage);
            }
            else if(transition.equals(States.PROFILE)){
                return new ProfileController(db, stage, user);
            }
        }
        else if(state.equals(States.LOGGED_OUT)){
            if(transition.equals(States.SWIPING)){
                return new SwipeController(db, stage, user, swipelist);
            }
            else if(transition.equals(States.REGISTRATION)){
                return new RegistrationController(db, stage, inputs);
            }
        }
        else if(state.equals(States.MATCHES) && transition.equals(States.MESSAGING)) {
            return new MessageController(db, stage, user, user2);
        }


//        if (state.equals(States.SWIPING) && transition.equals(States.LOGGED_OUT)){
//            return new LogInController(db, stage);
//        }
//        else if (state.equals(States.SWIPING) && transition.equals(States.MATCHES)){
//            return new MatchController(db, stage, user);
//        }
//        else if (state.equals(States.SWIPING) && transition.equals(States.PROFILE)){
//            return new ProfileController(db, stage, user);
//        }
//        else if (state.equals(States.SWIPING) && (transition.equals(States.SWIPING))){
//            return new SwipeController(db, stage, id, swipelist);
//        }
//        else if (state.equals(States.MATCHES) && transition.equals(States.MESSAGING)){
//            return new MessageController(db, stage, user, user2);
//        }
//        else if ((state.equals(States.PROFILE) || state.equals(States.MATCHES)) && transition.equals(States.BACK)){
//            return new SwipeController(db, stage, user, swipelist);
//        }
//
//        else if (state.equals(States.MESSAGING) && transition.equals(States.BACK)){
//            return new MatchController(db, stage, user);
//        }
//        else if (state.equals(States.REGISTRATION) && transition.equals(States.BACK)){
//            return new LogInController(db, stage);
//        }
//
//        else if (state.equals(States.LOGGED_OUT) && transition.equals(States.SWIPING)){
//            return new SwipeController(db, stage, user, swipelist);
//        }
//
//        else if (state.equals(States.LOGGED_OUT) && transition.equals(States.REGISTRATION)){
//            return new RegistrationController(db, stage, inputs);
//        }


        return new SwipeController(db, stage, user, swipelist);


        }
    }
}
