package Phase1.States;

import Phase1.UserActions.Action;
import Phase1.UserActions.Back;
import Phase1.UserActions.Message;

public class Matches extends State{
    public Matches(){}
    @Override
    public State transition(Action a){
        if (a instanceof Message){
            return new Messaging();
        }
        else if (a instanceof Back){
            return new LoggedIn();
        }
        return this;
    }
}
