package phase2.controllers;

import phase2.dataaccess.DataAccessInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import phase2.presenters.*;
import phase2.usecase.SwipeCase;

import java.util.*;

public class SwipeController extends Controller {

    private final SwipeCase swiper;
    private final Queue<Integer> swipeList;

    /**
     * @param db A reference to our Database so we can read and write to it.
     * @param stage the main stage where we display the scene.
     * @param id the id of the currently logged-in User.
     * @param swipeList a list of IDs that the currently logged-in User can swipe on. (they have not already
     * liked any of these users.)
     */
    public SwipeController(DataAccessInterface db, Stage stage, int id, Queue<Integer> swipeList) {
        super(db, stage);
        this.swipeList = swipeList;
        swiper = new SwipeCase(db, id, swipeList);
    }

    public boolean isEmpty(){
        return swipeList.isEmpty();
    }


    /**
     * Swipes right (likes) the currently displayed User.
     * @return an EventHandler that runs the swipe right functions.
     */
    public EventHandler<ActionEvent> swipeRight() {

        EventHandler<ActionEvent> event;

        event = e -> {

            boolean empty = swiper.likeCurrentUser();

            updateView(empty);

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

            updateView(empty);

        };

        return event;

    }

    /**
     * Refreshes and recreates the SwipeView.
     * @param empty A boolean that is true if there are no more people to swipe on.
     */
    private void updateView(boolean empty) {
        View view = new SwipeView(this);
        view.build();
    }

    /**
     * Refreshing the SwipeView means creating a new SwipeController and swipeList.
     * @return an EventHandler that runs the refresh function.
     */
    public EventHandler<ActionEvent> refresh() {

        EventHandler<ActionEvent> event;

        event = e -> new SwipeView();

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
