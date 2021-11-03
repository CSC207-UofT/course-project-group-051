package Phase1.States;


/**
 * Represents a state of our program which determines what actions the user can take and what the user sees.
 */
public interface State {

    State transition(String a);

}
