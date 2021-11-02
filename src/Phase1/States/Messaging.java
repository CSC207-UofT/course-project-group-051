package Phase1.States;

import Phase1.UserActions.Action;
import Phase1.UserActions.Back;


/**
 * Represents the state where the user can message other users.
 */
public class Messaging extends State{


    public Messaging(){}

    /**
     * Decides which new state should be transitioned to.
     * @param a the action taken by the user that will determine the state the program will  transition to.
     * @return the state to which the program will transition.
     */
    @Override
    public State transition(Action a){
        if (a instanceof Back){
            return new LoggedIn();
        }
        return this;
    }
}
