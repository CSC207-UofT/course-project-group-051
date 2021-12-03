package phase2.controllers;

import phase2.controllers.states.State;
import phase2.controllers.states.States;

public class StateMachine {

    State state;

    public StateMachine(){
        state = States.LoggedOut;
    }

    public void transition(String newState){
        //TODO
    }
}
