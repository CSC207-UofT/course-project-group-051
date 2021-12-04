package phase2.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;
import phase2.dataaccess.DataAccessInterface;
import phase2.presenters.LoginView;
import phase2.presenters.SwipeView;
import phase2.presenters.View;
import phase2.usecase.LogInCase;

import java.util.Map;


public class RegistrationController extends Controller{

    DataAccessInterface db;
    Stage stage;
    Map<String, TextInputControl> inputs;
    EventHandler<ActionEvent> event;

    public RegistrationController(DataAccessInterface db, Stage stage, Map<String, TextInputControl> inputs){
        this.db = db;
        this.stage = stage;
        this.inputs = inputs;
    }

    public EventHandler<ActionEvent> login(){
        event = e -> {
            //TODO
        };
        return event;
    }

    public EventHandler<ActionEvent> createAccount(){
        event = e -> {
            //TODO
        };
        return event;
    }
}
