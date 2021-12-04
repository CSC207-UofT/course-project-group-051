package phase2.constants;

/**
 * A class storing the static variable state and changes the state.
 */
public class State {
    private static String state; // the current state

    /**
     * Private constructor since we don't need to create such an object.
     */
    private State(){}

    /**
     * @return the String value of the current state.
     */
    public static String getState(){
        return state;
    }

    /** Updates the state to the given state.
     * @param s the desired state.
     */
    public void setState(String s){
        state = s;
    }
}
