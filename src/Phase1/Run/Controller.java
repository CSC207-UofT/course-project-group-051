package Phase1.Run;

import Phase1.States.State;
import Phase1.States.States;
import Phase1.Users.ProfileUser;
import javafx.stage.Stage;

public class Controller {
    State state;
    public Controller(){
        this.state = States.LoggedOut;
    }
    //TODO
    public void update(State nextState, ProfileUser primaryUser, ProfileUser secondUser){


    }
    public void updateView(Stage s){

    }




}
