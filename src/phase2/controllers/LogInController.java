package phase2.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import phase2.dataaccess.DataAccessInterface;
import javafx.event.EventHandler;
import phase2.presenters.LoginView;
import phase2.presenters.RegistrationView;
import phase2.presenters.SwipeView;
import phase2.presenters.View;
import phase2.usecase.LogInCase;
import javafx.stage.Stage;


public class LogInController {

    DataAccessInterface db;
    TextField username;
    PasswordField password;
    EventHandler<ActionEvent> event;
    Stage stage;


    public LogInController(DataAccessInterface db, Stage stage, TextField username, PasswordField password){
        this.db = db;
        this.username = username;
        this.password = password;
        this.stage = stage;
    }


    public EventHandler<ActionEvent> login(){
        event = e -> {
            LogInCase logInCase = new LogInCase(db);
            int logInResult = logInCase.loginUser(username.getText(), password.getText());
            View view = null;
            if(logInResult == -1){
                view = new LoginView(true, db, stage);
            }
            else{
                //view = new SwipeView();
            }
            view.build();
        };
        return event;
    }

    public EventHandler<ActionEvent> register(){
        event = e -> {
            View view = new RegistrationView(db, stage);
            view.build();
        };
        return event;
    }
}
