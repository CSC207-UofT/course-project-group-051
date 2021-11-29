package phase2.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;
import phase2.dataaccess.DataAccessInterface;
import phase2.presenters.LoginView;
import phase2.presenters.RegistrationView;
import phase2.presenters.SwipeView;
import phase2.presenters.View;
import phase2.usecase.Registration.RegistrationCase;
import phase2.usecase.LogInCase;


import java.util.Map;


public class RegistrationController {

    DataAccessInterface db;
    Stage stage;
    Map<String, TextInputControl> inputs;
    EventHandler<ActionEvent> event;

    public RegistrationController(DataAccessInterface db, Stage stage, Map<String, TextInputControl> inputs){
        this.db = db;
        this.stage = stage;
        this.inputs = inputs;
    }


//    public EventHandler<ActionEvent> login(){
//        event = e -> {
//            // TODO
//        };
//        return event;
//    }

    public EventHandler<ActionEvent> createAccount(){
        event = e -> {
            RegistrationCase rcase = new RegistrationCase(db);
            int result = rcase.createAccount(inputs);
            View view;
            if(result == -1){
                view = new RegistrationView(db, stage); // return error in view?
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
