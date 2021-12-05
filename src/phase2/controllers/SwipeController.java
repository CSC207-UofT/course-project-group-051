package phase2.controllers;

import phase2.constants.States;
import phase2.dataaccess.DataAccessInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import phase2.constants.State;
import phase2.presenters.*;
import phase2.usecase.SwipeCase;

import java.util.*;

public class SwipeController extends Controller {

    private final SwipeCase swiper;
    private final int currentUser;

    /**
     * @param db A reference to our Database so we can read and write to it.
     * @param stage the main stage where we display the scene.
     * @param id the id of the currently logged-in User.
     * @param swipeList a list of IDs that the currently logged-in User can swipe on. (they have not already
     * liked any of these users.)
     */
    public SwipeController(Stage stage, DataAccessInterface db, int id, Queue<Integer> swipeList) {
        super(stage, db);
        State.setState(States.SWIPING);
        swiper = new SwipeCase(db, id, swipeList);
        currentUser = id;
    }

    /**
     * Swipes right (likes) the currently displayed User.
     * @return an EventHandler that runs the swipe right functions.
     */
    public EventHandler<ActionEvent> swipeRight() {

        EventHandler<ActionEvent> event;

        event = e -> {

            boolean empty = swiper.likeCurrentUser();

            refreshView(empty);

        };

        return event;
    }

    /**
     * Swipes left on the currently displayed User.
     * @return an EventHandler that runs the swipe left functions.
     */
    public EventHandler<ActionEvent> swipeLeft() {

        EventHandler<ActionEvent> event;

        event = e -> {

            boolean empty = swiper.nextUser();

            refreshView(empty);

        };

        return event;

    }

    /**
     * Refreshes and recreates the SwipeView or EmptyView depending on if the swipeList is empty.
     * @param empty A boolean that is true if there are no more people to swipe on.
     */
    private void refreshView(boolean empty) {
        View view;
        if (empty) {
            view = new EmptySwipeView(db, stage);
        } else {
            view = new SwipeView(this, stage);
        }
        view.build();
    }

    /**
     * @return an EventHandler that runs the refresh function.
     */
    public EventHandler<ActionEvent> refresh() {

        EventHandler<ActionEvent> event;

        event = e -> {

            Queue<Integer> swipeList =



        };

        return event;

    }

    /**
     * @return an EventHandler that runs the logOut function.
     */
    public EventHandler<ActionEvent> logOut() {

        EventHandler<ActionEvent> event;

        event = e -> {

            View view = new LoginView(false, db, stage);
            view.build();

        };

        return event;

    }


    /**
     * @return an EventHandler that runs the changeProfileView function.
     */
    public EventHandler<ActionEvent> changeProfileView() {

        EventHandler<ActionEvent> event;

        event = e -> {

            View view = new ProfileView(db, stage, currentUser);
            view.build();

        };

        return event;

    }

    /**
     * @return an EventHandler that runs the changeMatchView function.
     */
    public EventHandler<ActionEvent> changeMatchView() {

        EventHandler<ActionEvent> event;

        event = e -> {

            View view = new matchView(db, stage, currentUser);
            view.build();

        };

        return event;

    }

    /**
     * @return an EventHandler that runs the getCurrentImage function.
     */
    public ImageView getCurrentImage() {

        return swiper.getImage();

    }

    /**
     * @return an EventHandler that runs the getUserData function.
     */
    public Map<String, String> getUserData(){

        return swiper.getData();

    }
}
