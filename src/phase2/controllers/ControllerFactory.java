package phase2.controllers;

import javafx.stage.Stage;
import phase2.constants.State;
import phase2.constants.States;
import phase2.dataaccess.DataAccessInterface;
import phase2.dataaccess.DataBaseAccess;

import java.util.*;

/**
 * A factory that streamlines the creation of controller objects.
 */
public class ControllerFactory {


    DataAccessInterface db; //A reference to our Database.
    Stage stage; //A reference to the Stage where we display the views.
    int currentUser; //The id of the currently logged-in User.
    final static ControllerFactory controllerFactory = new ControllerFactory(); //The single Factory instance.


    /**
     * Creates an instance of ControllerFactory.
     */
    public ControllerFactory(){
        db = new DataBaseAccess();

    }


    /**
     * @return the currently held controllerFactory instance.
     */
    public static ControllerFactory getInstance(){
        return controllerFactory;
    }


    public void setStage(Stage stage){
        this.stage = stage;
    }


    /**
     * Sets the currentUser.
     * @param id the currentUser's ID.
     */
    public void setCurrentUser(int id){
        this.currentUser = id;
    }


    /**
     * @return a MatchController for the currentUser.
     */
    public MatchController getMatchController(){

        return new MatchController(db, stage, currentUser);

    }


    /**
     * @return a LogInController for this run.
     */
    public LogInController getLogInController(){

        return new LogInController(db, stage);

    }


    /**
     * @param receiver the receiver of the messages.
     * @return a MessageController with a designated receiver of the messages and currentUser.
     */
    public MessageController getMessageController(int receiver){

        return new MessageController(db, stage, currentUser, receiver);

    }


    /**
     * @return a ProfileController for the currentUser.
     */
    public ProfileController getProfileController(){

        return new ProfileController(db, stage, currentUser);

    }


    /**
     * @return a RegistrationController for the currentUser.
     */
    public RegistrationController getRegistrationController(){

        return new RegistrationController(db, stage, currentUser); //constructor seems wrong here.

    }


    /**
     * Creates the swipeList and returns the SwipeController for the currentUser.
     * @return a SwipeController for the currentUser.
     */
    public SwipeController getSwipeController(){

        Queue<Integer> swipeList = filterSwipeList();
        return new SwipeController(db, stage, currentUser, swipeList);

    }


    /**
     * Removes all the already liked Users from the currentUser's potential swipes.
     * @return a list of IDs that the current SelfUser can swipe on.
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


//
//    /**
//     * @param transition A command taken by the user.
//     * @return the appropriate controller for the given state.
//     */
//    public Controller getController(String transition){
//        String state = State.getState();
//        if(transition.equals(States.BACK)) {
//            if(state.equals(States.MESSAGING)){
//                State.setState(States.MATCHES);
//                return new MatchController(db, stage, currentUser);
//            }
//            else if(state.equals(States.PROFILE) || state.equals(States.MATCHES)){
//                State.setState(States.SWIPING);
//                return new SwipeController(stage, db, currentUser, filterSwipeList());
//            }
//            else if(state.equals(States.REGISTRATION)){
//                State.setState(States.LOGGED_OUT);
//                return new LogInController(db, stage);
//            }
//        }
//        else if(state.equals(States.SWIPING)){
//            if(transition.equals(States.LOGGED_OUT)){
//                State.setState(States.LOGGED_OUT);
//                return new LogInController(db, stage);
//            }
//            else if(transition.equals(States.MATCHES)){
//                State.setState(States.MATCHES);
//                return new MatchController(db, stage);
//            }
//            else if(transition.equals(States.PROFILE)){
//                State.setState(States.PROFILE);
//                return new ProfileController(db, stage, currentUser);
//            }
//        }
//        else if(state.equals(States.LOGGED_OUT)){
//            if(transition.equals(States.SWIPING)){
//                State.setState(States.SWIPING);
//                return new SwipeController(stage, db, currentUser, filterSwipeList());
//            }
//            else if(transition.equals(States.REGISTRATION)){
//                State.setState(States.REGISTRATION);
//                return new RegistrationController(db, stage, inputs);
//            }
//        }
//        else if(state.equals(States.MATCHES) && transition.equals(States.MESSAGING)) {
//            State.setState(States.MESSAGING);
//            return new MessageController(db, stage, currentUser, user2);
//        }
//        else if(state.equals(States.REGISTRATION) && transition.equals(States.SWIPING)) {
//            State.setState(States.SWIPING);
//            return new SwipeController(stage, db, currentUser, filterSwipeList());
//        }
//

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
//
//        return null;
//
//        }

}

