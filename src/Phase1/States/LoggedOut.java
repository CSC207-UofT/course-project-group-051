package Phase1.States;

import Phase1.UserActions.Action;
import Phase1.UserActions.LogIn;
import Phase1.UserActions.Register;
import Phase1.Users.User;

public class LoggedOut extends State
{

    public LoggedOut(){
        super();
    }
    @Override
    public State transition(Action a){
        if (a instanceof LogIn){
            return new LoggedIn();
        }
        else if (a instanceof Register){
            return new Registration();
        }
        return this;
    }
}
