package Phase1.States;

import Phase1.UserActions.Action;

/**
 * Represents a state of our program which determines what actions the user can take and what the user sees.
 */
public abstract class State { //seems more like an interface.

    public State(){}

    public State transition(Action a){
        return null;
    }

}
