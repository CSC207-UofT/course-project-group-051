package Phase1.States;

import Phase1.UserActions.Actions;

/**
 * Represents the state where a user can swipe on matches.
 */
public class Matches extends State{
    public Matches(){}
    /**
     * Determines which state the program should transition to.
     * @param s the action taken by the user which will determine which state the program will transition to.
     * @return the state which the program will transition to.
     */
    @Override
    public State transition(String s){
        if (s.equals(Actions.MESSAGE)){
            return States.Messaging;
        }
        else if (s.equals(Actions.BACK)){
            return States.LoggedIn;
        }
        return States.Matches;
    }
}
