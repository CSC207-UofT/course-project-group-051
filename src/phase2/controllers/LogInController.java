package phase2.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import phase2.constants.State;
import phase2.dataaccess.DataAccessInterface;
import javafx.event.EventHandler;
import phase2.presenters.LoginView;
import phase2.presenters.RegistrationView;
import phase2.presenters.SwipeView;
import phase2.presenters.View;
import phase2.usecase.LogInCase;
import javafx.stage.Stage;

/**
 * The controller that delegates tasks for each button in the log in view.
 */
public class LogInController implements Controller{

    DataAccessInterface db; //the Data Access Interface.
    TextField username; //the Username text field.
    PasswordField password; //the password field.
    EventHandler<ActionEvent> event; //the event placeholder.
    Stage stage; //the main stage.

    /**
     * Creates an instance of LogInController.
     * @param db the data access interface.
     * @param stage the main stage.
     */
    public LogInController(DataAccessInterface db, Stage stage){
        super(db, stage);
        State.setState(States.LoggedOut);
    }

    /**
     * Sets the textfield to the given text fields.
     * @param username the username text field.
     * @param password the password text field.
     */
    public void setTextField(TextField username, PasswordField password){
        this.username = username;
        this.password = password;

    }

    /**
     * @return the task delegation after the log in button is pressed.
     */
    public EventHandler<ActionEvent> login(){
        event = e -> {
            LogInCase logInCase = new LogInCase(db);
            int logInResult = logInCase.loginUser(username.getText(), password.getText());
            View view;
            if(logInResult == -1){
                view = new LoginView(true, db, stage);
            }
            else{
                view = new SwipeView();
            }
            view.build();
        };
        return event;
    }

    /**
     * @return the task delegation when the register button is pressed.
     */
    public EventHandler<ActionEvent> register(){
        event = e -> {
            View view = new RegistrationView(db, stage);
            view.build();
        };
        return event;
    }
}
