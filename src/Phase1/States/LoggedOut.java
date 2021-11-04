package Phase1.States;

import Phase1.UserActions.Actions;


/**
 * Represents the state before the user has logged in. Which gives them the option to login or register.
 */
public class LoggedOut extends State
{
    public LoggedOut(){
        super();
    }

    /**
     * Determines which state should be transitioned to.
     * @param s the action which the user took which will determine where the program will transition to.
     * @return the State which the program will transition to.
     */
    @Override
    public State transition(String s){
        if (s.equals(Actions.LOGIN)){
            return States.LoggedIn;
        }
        else if (s.equals(Actions.REGISTER)){
            return States.Registration;
        }
        return States.LoggedOut;
    }
}
