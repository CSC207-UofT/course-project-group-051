package phase2.controllers;

import javafx.stage.Stage;
import phase2.constants.State;
import phase2.constants.States;
import phase2.dataaccess.DataAccessInterface;
import phase2.dataaccess.DataBaseAccess;
import phase2.users.OtherUser;

import java.util.*;

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

    int currentUser;
    int user2;
    HashMap registrationInputs;
    DataAccessInterface db;
    Stage stage;
    Queue<Integer> swipeList;
    final static MainController mainController = new MainController();

    /** Creates an instance of MainController.
     * @param db the data access interface.
     * @param stage stage the main stage.
     */
    public MainController(){
        db = new DataBaseAccess();

    }

    public static MainController getInstance(){
        return mainController;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    /**
     * Sets the primary user.
     * @param id the primary user's ID.
     */
    public void setPrimaryUser(int id){
        this.currentUser = id;
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
     * @param transition A command taken by the user.
     * @return the appropriate controller for the given state.
     */
    public Controller getController(String transition){
        String state = State.getState();
        if(transition.equals(States.BACK)) {
            if(state.equals(States.MESSAGING)){
                State.setState(States.MATCHES);
                return new MatchController(db, stage, currentUser);
            }
            else if(state.equals(States.PROFILE) || state.equals(States.MATCHES)){
                State.setState(States.SWIPING);
                return new SwipeController(stage, db, currentUser, filterSwipeList());
            }
            else if(state.equals(States.REGISTRATION)){
                State.setState(States.LOGGED_OUT);
                return new LogInController(db, stage);
            }
        }
        else if(state.equals(States.SWIPING)){
            if(transition.equals(States.LOGGED_OUT)){
                State.setState(States.LOGGED_OUT);
                return new LogInController(db, stage);
            }
            else if(transition.equals(States.MATCHES)){
                State.setState(States.MATCHES);
                return new MatchController(db, stage);
            }
            else if(transition.equals(States.PROFILE)){
                State.setState(States.PROFILE);
                return new ProfileController(db, stage, currentUser);
            }
        }
        else if(state.equals(States.LOGGED_OUT)){
            if(transition.equals(States.SWIPING)){
                State.setState(States.SWIPING);
                return new SwipeController(stage, db, currentUser, filterSwipeList());
            }
            else if(transition.equals(States.REGISTRATION)){
                State.setState(States.REGISTRATION);
                return new RegistrationController(db, stage, inputs);
            }
        }
        else if(state.equals(States.MATCHES) && transition.equals(States.MESSAGING)) {
            State.setState(States.MESSAGING);
            return new MessageController(db, stage, currentUser, user2);
        }
        else if(state.equals(States.REGISTRATION) && transition.equals(States.SWIPING)) {
            State.setState(States.SWIPING);
            return new SwipeController(stage, db, currentUser, filterSwipeList());
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

        return null;

        }

    /**
     * Removes all the already liked Users from the current SelfUser's list.
     * @return a list of OtherUsers that the current SelfUser can swipe on.
     */
    private Queue<Integer> filterSwipeList() {

        List<Integer> unfiltered = db.getSwipeList(currentUser);
        Queue<Integer> filtered = new LinkedList<>();

        //Loop through the list of unfiltered users
        for (int unfilteredUser : unfiltered) {

            //get all the users who admired the current user we are reviewing
            ArrayList<Integer> currentAdmirers = db.getAdmires(unfilteredUser);

            //if the current SelfUser has already admired this user, then don't include him in the final list.
            if(!currentAdmirers.contains(currentUser)) {
                filtered.add(unfilteredUser);
            }

        }

        return filtered;
    }

    public void setError(boolean error) {
    }
}

