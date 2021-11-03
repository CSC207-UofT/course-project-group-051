package Phase1.States;


import Phase1.UserActions.Actions;

/**
 * Represents the state where the user can message other users.
 */
public class Messaging extends State{

    public Messaging(){}

    /**
     * Decides which new state should be transitioned to.
     * @param s the action taken by the user that will determine the state the program will  transition to.
     * @return the state to which the program will transition.
     */
    @Override
    public State transition(String s){
        if (s.equals(Actions.BACK)){
            return States.LoggedIn;
        }
        return States.Messaging;
    }
}
