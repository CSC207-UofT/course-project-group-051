package phase2.controllers;

import com.oracle.tools.packager.Log;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;
import phase2.constants.State;
import phase2.dataaccess.DataAccessInterface;
import phase2.presenters.LoginView;
import phase2.presenters.RegistrationView;
import phase2.presenters.SwipeView;
import phase2.presenters.View;
import phase2.usecase.ErrorBuilder;
import phase2.usecase.Registration.RegistrationCase;
import phase2.usecase.LogInCase;


import java.util.ArrayList;
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
        State.setState(States.Registration);
    }


    public EventHandler<ActionEvent> back(){
        event = e -> {
            View view = new LoginView(false, db, stage);
            view.build();
        };
        return event;
    }

    public EventHandler<ActionEvent> createAccount(){
        event = e -> {
            RegistrationCase rcase = new RegistrationCase(db);
            ArrayList<String> results = rcase.createAccount(inputs);
            View view;
            if(!results.isEmpty()){
                view = new RegistrationView(db, stage, ErrorBuilder.build(results)); // return error in view?
            } else {
                LogInCase logInCase = new LogInCase(db);
                int logInResult = logInCase.loginUser(
                        inputs.get("username").getText(),
                        inputs.get("password").getText());
                if(logInResult == -1){
                    view = new LoginView(false, db, stage);
                } else {
                    view = new SwipeView();
                }
                view.build();
            }
            view.build();
        };
        return event;
    }
}
