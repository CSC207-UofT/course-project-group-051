package Phase1.States;

import Phase1.UserActions.Action;
import Phase1.UserActions.Back;

public class SelfProfile extends State{
    public SelfProfile(){}
    @Override
    public State transition(Action a){
        if (a instanceof Back){
            return new LoggedIn();
        }
        return this;
    }
}
