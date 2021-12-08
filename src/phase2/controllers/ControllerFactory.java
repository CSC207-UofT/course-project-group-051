package phase2.controllers;

import javafx.stage.Stage;
import phase2.dataaccess.DataAccessInterface;
import phase2.dataaccess.DataBaseAccess;
import phase2.usecase.SwipeListMaker;
import phase2.users.PublicUser;
import phase2.users.SelfUser;

import java.util.*;

/**
 * A factory that streamlines the creation of controller objects.
 */
public class ControllerFactory {


    DataAccessInterface db; //A reference to our Database.
    Stage stage; //A reference to the Stage where we display the views.
    SelfUser currentUser; //The id of the currently logged-in User.
    final static ControllerFactory controllerFactory = new ControllerFactory(); //The single Factory instance.


    /**
     * Creates an instance of ControllerFactory.
     */
    private ControllerFactory(){
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
     * @param user the currentUser.
     */
    public void setCurrentUser(SelfUser user){
        this.currentUser = user;
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

        return new RegistrationController(db, stage); //constructor seems wrong here.

    }


    /**
     * Creates the swipeList and returns the SwipeController for the currentUser.
     * @return a SwipeController for the currentUser.
     */
    public SwipeController getSwipeController(){

        Queue<PublicUser> swipeList = SwipeListMaker.filterSwipeList(db, currentUser);
        return new SwipeController(db, stage, currentUser, swipeList);

    }


//    /**
//     * Removes all the already liked Users from the currentUser's potential swipes.
//     * @return a list of IDs that the current SelfUser can swipe on.
//     */
//    private Queue<PublicUser> filterSwipeList() {
//
//        List<Integer> unfiltered = db.getSwipeList(currentUser.getId());
//        Queue<PublicUser> filtered = new LinkedList<>();
//
//        //Loop through the list of unfiltered users
//        for (int unfilteredUser : unfiltered) {
//
//            //get all the users who admired the current user we are reviewing
//            ArrayList<Integer> currentAdmirers = db.getAdmires(unfilteredUser);
//
//            //if the current SelfUser has already admired this user, then don't include him in the final list.
//            if(!currentAdmirers.contains(currentUser.getId())) {
//                filtered.add(new PublicUser(unfilteredUser));
//            }
//
//        }
//
//        return filtered;
//    }
}

