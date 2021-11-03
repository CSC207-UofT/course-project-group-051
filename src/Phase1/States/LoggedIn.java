package Phase1.States;

import Phase1.UserActions.*;
import Phase1.Views.Controller;

/**
 * Represents the default landing page (or "home" page) of our program, where you are allowed to
 * transition of other pages or Logout.
 */
public class LoggedIn extends State {

    public LoggedIn(){}

    /**
     * Decides which new state should be transitioned to.
     * @param s the action taken by the user that will determine the state the program will  transition to.
     * @return the state to which the program will transition.
     */
    @Override
    public State transition(String s){
        if (s.equals(Actions.SHOWMATCHES)){
            return States.Matches;
        }
        else if(s.equals(Actions.LOGOUT)){
            return States.LoggedOut;
        }
        else if(s.equals(Actions.VIEWSELF)){
            return States.SelfProfile;
        }
        Controller.nextProfile();
        Controller.updateView();
        return States.LoggedIn;
    }
}
