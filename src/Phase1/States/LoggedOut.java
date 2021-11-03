package Phase1.States;

import Phase1.UserActions.Actions;
import Phase1.UserActions.LogIn;
import Phase1.UserActions.Register;
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
     * @param a the action which the user took which will determine where the program will transition to.
     * @return the State which the program will transition to.
     */
    @Override
    public State transition(String a){
        if (a.equals(LOGIN)){
            return new LoggedIn();
        }
        else if (a.equals(REGISTER)){
            return new Registration();
        }
        return this;
    }
}
