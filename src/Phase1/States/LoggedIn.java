package Phase1.States;

import static Phase1.UserActions.Actions.*;

/**
 * Represents the default landing page (or "home" page) of our program, where you are allowed to
 * transition of other pages or Logout.
 */
public class LoggedIn implements State {

    public LoggedIn(){}

    /**
     * Decides which new state should be transitioned to.
     * @param a the action taken by the user that will determine the state the program will  transition to.
     * @return the state to which the program will transition.
     */
    @Override
    public State transition(String a){
        if (a.equals(SHOWMATCHES)){
            return new Matches();
        }
        else if(a.equals(LOGOUT)){
            return new LoggedOut();
        }
        else if(a.equals(VIEWSELF)){
            return new SelfProfile();
        }
        return this;
    }
}
