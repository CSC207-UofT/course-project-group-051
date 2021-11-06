package Phase1.Run;

import Phase1.States.State;
import Phase1.States.States;
import Phase1.UserActions.Actions;
import Phase1.Users.ProfileUser;
import Phase1.Views.LogInViewBuilder;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.util.ArrayList;

public class Controller {
    State state;
    public Controller(){
        this.state = States.LoggedOut;
    }
    //TODO
    public State update(String action, ProfileUser primaryUser, ProfileUser secondUser){
      this.state = this.state.transition(action);
      return this.state;
    }
    }

