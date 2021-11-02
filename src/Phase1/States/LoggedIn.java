package Phase1.States;

import Phase1.UserActions.*;


public class LoggedIn extends State {
    public LoggedIn(){}

    @Override
    public State transition(Action a){
        if (a instanceof ShowMatches){
            return new Matches();
        }
        else if(a instanceof LogOut){
            return new LoggedOut();
        }
        else if(a instanceof ViewSelf){
            return new SelfProfile();
        }
        return this;
    }
}
