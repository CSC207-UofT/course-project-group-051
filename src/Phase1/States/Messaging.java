package Phase1.States;

import static Phase1.UserActions.Actions.*;


/**
 * Represents the state where the user can message other users.
 */
public class Messaging implements State {

    public Messaging(){}

    /**
     * Decides which new state should be transitioned to.
     * @param a the action taken by the user that will determine the state the program will  transition to.
     * @return the state to which the program will transition.
     */
    @Override
    public State transition(String a){
        if (a.equals(BACK)){
            return new LoggedIn();
        }
        return this;
    }
}
