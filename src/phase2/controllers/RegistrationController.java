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
import phase2.usecase.ErrorBuilder;
import phase2.usecase.RegistrationCase;
import phase2.usecase.LogInCase;
import phase2.userbuilders.SelfUserBuilder;

import java.util.ArrayList;
import java.util.Map;


/**
 * A controller that registers non-existing users
 */
public class RegistrationController extends Controller{

    EventHandler<ActionEvent> event;

    /**
     * Creates instance of RegistrationController
     *
     * @param db, an instance of data access interface
     * @param stage, the main stage
     */
    public RegistrationController(DataAccessInterface db, Stage stage){
        super(db, stage);
    }

    /**
     * @return EventHandler that returns the LoginView
     */
    public EventHandler<ActionEvent> back(){
        event = e -> {
            View view = new LoginView(ErrorBuilder.build(new ArrayList<>()));
            view.build();
        };
        return event;
    }

    /** @return EventHandler that adds a new user to the db
     *
     * @param inputs, data from RegistrationView submission
     */
    public EventHandler<ActionEvent> createAccount(Map<String, TextInputControl> inputs){
        event = e -> {
            RegistrationCase registrationCase = new RegistrationCase(db);

            ArrayList<String> results = registrationCase.createAccount(inputs);
            View view;
            if(!results.isEmpty()){
                view = new RegistrationView(ErrorBuilder.build(results)); // return error in view?
            } else {
                LogInCase logInCase = new LogInCase(db);
                int logInResult = logInCase.loginUser(
                        inputs.get("uTID").getText(),
                        inputs.get("password").getText());
                ControllerFactory.getInstance().setCurrentUser(SelfUserBuilder.build(db, logInResult));
                view = new SwipeView();
            }
            view.build();
        };
        return event;
    }
}
