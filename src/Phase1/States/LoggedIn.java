package Phase1.States;

import Phase1.UserActions.*;


/**
 * Represents the default landing page (or "home" page) of our program, where you are allowed to
 * transition of other pages or Logout.
 */
public class LoggedIn extends State {


    public LoggedIn(){}


    /**
     * Decides which new state should be transitioned to.
     * @param a the action taken by the user that will determine the state the program will  transition to.
     * @return the state to which the program will transition.
     */
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
