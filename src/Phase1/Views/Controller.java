package Phase1.Views;

import Phase1.States.LoggedOut;
import Phase1.States.State;

public class Controller {
    State state;
    public Controller(){
        this.state = new LoggedOut();
    }

}
