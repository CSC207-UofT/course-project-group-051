package phase2.controllers;

import phase2.dataaccess.DataAccessInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import phase2.presenters.*;
import phase2.usecase.SwipeCase;
import phase2.users.PublicUser;
import phase2.users.SelfUser;

import java.util.*;

public class SwipeController extends Controller {

    public SwipeCase swiper;

    /**
     * @param db A reference to our Database so we can read and write to it.
     * @param stage the main stage where we display the scene.
     * @param currentUser the currently logged-in User.
     * @param swipeList a list of IDs that the currently logged-in User can swipe on. (they have not already
     * liked any of these users.)
     */
    public SwipeController(DataAccessInterface db, Stage stage, SelfUser currentUser, Queue<PublicUser> swipeList) {
        super(db, stage);
        swiper = new SwipeCase(db, currentUser, swipeList);
    }

    public boolean isEmpty(){
        return swiper.isEmpty();
    }


    /**
     * Swipes right (likes) the currently displayed User.
     * @return an EventHandler that runs the swipe right functions.
     */
    public EventHandler<ActionEvent> swipeRight() {

        EventHandler<ActionEvent> event;

        event = e -> {

            swiper.likeCurrentUser();
            updateView();
        };

        return event;
    }

    /**
     * Swipes left on the currently displayed User.
     * @return an EventHandler that runs the swipe left functions.
     */
    public EventHandler<ActionEvent> swipeLeft() {

        EventHandler<ActionEvent> event;

        event = e -> updateView();

        return event;

    }

    /**
     * Refreshes and recreates the SwipeView.
     */
    private void updateView() {
        View view = new SwipeView(this);
        view.build();
    }

    /**
     * Refreshing the SwipeView means creating a new SwipeController and swipeList.
     * @return an EventHandler that runs the refresh function.
     */
    public EventHandler<ActionEvent> refresh() {

        EventHandler<ActionEvent> event;

        event = e -> {
            View view = new SwipeView();
            view.build();
        };

        return event;

    }

    /**
     * @return an EventHandler that runs the logOut function.
     */
    public EventHandler<ActionEvent> logOut() {

        EventHandler<ActionEvent> event;

        event = e -> {

            View view = new LoginView();
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

            View view = new ProfileView();
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

            View view = new MatchView();
            view.build();

        };

        return event;

    }

    /**
     * @return an EventHandler that runs the getCurrentImage function.
     */
    public String getCurrentImage() {

        return swiper.getImage();

    }

    /**
     * @return an EventHandler that runs the getUserData function.
     */
    public Map<String, String> getUserData(){

        return swiper.getData();

    }
}
