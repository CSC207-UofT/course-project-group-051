package Phase1.States;

import Phase1.UserActions.Action;
import Phase1.UserActions.Back;
import Phase1.UserActions.Message;


/**
 * Represents the state where a user can swipe on matches.
 */
public class Matches extends State{



    public Matches(){}

    /**
     * Determines which state the program should transition to.
     * @param a the action taken by the user which will determine which state the program will transition to.
     * @return the state which the program will transition to.
     */
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
