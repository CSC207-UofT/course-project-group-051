package phase2.controllers.states;

public interface State {
    State transition(String s);

}
