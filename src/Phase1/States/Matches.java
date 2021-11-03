package Phase1.States;

import static Phase1.UserActions.Actions.*;

/**
 * Represents the state where a user can swipe on matches.
 */
public class Matches implements State {
    public Matches(){}
    /**
     * Determines which state the program should transition to.
     * @param a the action taken by the user which will determine which state the program will transition to.
     * @return the state which the program will transition to.
     */
    @Override
    public State transition(String a){
        if (a.equals(MESSAGE)){
            return new Messaging();
        }
        else if (a.equals(BACK)){
            return new LoggedIn();
        }
        return this;
    }
}
