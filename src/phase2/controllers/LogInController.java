package phase2.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import phase2.dataaccess.DataAccessInterface;
import javafx.event.EventHandler;
import phase2.presenters.LoginView;
import phase2.usecase.LogInCase;

import java.util.function.Consumer;


public class LogInController {

    DataAccessInterface db;
    TextField username;
    PasswordField password;
    EventHandler<ActionEvent> login;


    public LogInController(DataAccessInterface db, TextField username, PasswordField password){
        this.db = db;
        this.username = username;
        this.password = password;
    }



    public EventHandler<ActionEvent> login(){
        login = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                LogInCase logInCase = new LogInCase(db);
                int logInResult = logInCase.loginUser(username.getText(), password.getText());
                if(logInResult == -1){
                    LoginView view = new LoginView();
                    view.build()
                }
            }
        };
        return login;
    }
}
