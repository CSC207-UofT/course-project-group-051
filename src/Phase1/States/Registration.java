package Phase1.States;

import Phase1.UserActions.Action;
import Phase1.UserActions.LogIn;

public class Registration extends State{
    public Registration(){
    }
    @Override
    public State transition(Action e){
        if (e instanceof LogIn){
            return new LoggedIn();
        }
        return this;
    }
}
