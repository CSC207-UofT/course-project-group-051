package phase2.controllers;

import Phase1.DataAccess.DataAccessInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import phase2.usecase.SwipeCase;

import java.util.Map;
import java.util.Queue;

public class SwipeController {

    private final Stage stage;
    private final int id;
    private final Queue<Integer> swipeList;
    private int currentTarget;
    DataAccessInterface db;

    public SwipeController(DataAccessInterface db, Stage stage, int id, Queue<Integer> swipeList) {

        this.db = db;
        this.stage = stage;
        this.id = id; //make into a user instead?
        this.swipeList = swipeList; //possibly make into list of swipeUsers?
        currentTarget = swipeList.poll();
    }

    public EventHandler<ActionEvent> swipeRight() {

        EventHandler<ActionEvent> event;

        event = e -> {

        };
        
        
        return event;
    }

    public EventHandler<ActionEvent> swipeLeft() {

    }

    public EventHandler<ActionEvent> refresh() {

    }

    public EventHandler<ActionEvent> logOut() {

    }


    public EventHandler<ActionEvent> changeProfileView() {

    }

    public EventHandler<ActionEvent> changeMatchView() {

    }


    public ImageView getCurrentImage() {

        SwipeCase swiper = new SwipeCase(currentTarget);

        return swiper.getImage();

    }

    public Map<String, String> getUserData(){

        SwipeCase swiper = new SwipeCase(currentTarget);

        return swiper.getData();

    }
}
