package Phase1.EventHandler;

import Phase1.Run.StateMachine;
import Phase1.States.Registration;
import Phase1.States.States;
import Phase1.UserActions.Actions;
import Phase1.Users.ProfileUser;
import Phase1.Views.LogInViewBuilder;
import Phase1.Views.RegistrationViewBuilder;
import Phase1.Views.SwipeViewBuilder;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.SceneBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

public class EventHandlerFactory {

    public EventHandlerFactory(){}

    public EventHandler LogInHandler(StateMachine c, Stage s, LogInViewBuilder sb, Database db){
        return e -> {
            if (c.getState().equals(States.LoggedOut)) {
                String username = sb.getUsername();
                String password = sb.getPassword();
                if (db.passwordCheck(username, password)) {
                    c.update(Actions.LOGIN, u, null);
                }
                ProfileUser u = db.getUser(username, password);
                ArrayList potentialMatches = db.getPotentialMatches(u);
                if (!potentialMatches.isEmpty()) {
                    SwipeViewBuilder sb1 = new SwipeViewBuilder(potentialMatches.get(0),
                            potentialMatches.get(0).getImage());
                    potentialMatches.remove(potentialMatches.get(0));
                }
            } else {
                c.update(Actions.LOGIN, null, null);
                sb.build(s);
            }
        };
    }

    public EventHandler Registration(StateMachine c, Stage s, RegistrationViewBuilder rb, Database db){
        return (EventHandler<ActionEvent>) event -> {
            c.update(Actions.REGISTER, null, null);
            RegistrationViewBuilder r = new RegistrationViewBuilder();
            r.build(s);
            String DOB = r.getDOB();
            String fName = r.getFirstName();
            String lName = r.getLastName();
            String username = r.userName();
            String pw1 = r.getPassword();
            String pw2 = r.getPassword1();
            String location = r.getPicturePath();

            if (pw1.equals(pw2) && !db.contains(username)) {
                try {
                    db.createUser(new ProfileUser(db.getSize(), fName, lName, new Date(DOB),
                            new ImageView(new Image(
                                    new FileInputStream("C:\\Users\\HP\\Desktop\\myimg.jpg")))));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
            else if(db.contains(username)){
                r.editMessage(false, true);
            }

            else{
                r.editMessage(true, false);
            }           };
    }

    public EventHandler SwipeRight(StateMachine c, Stage s, Database db){
        return (EventHandler<ActionEvent>) event -> {
            //TODO
                if (c.getState().equals(States.LoggedIn)){
                    ProfileUser user = db.getLoggedInUser();
                    ProfileUser otherUser = db.getPotentialUsers().get(0); //filter by preferences and get a list
                    // get current user displayed on swipe
                    // add admirer and liker
                    // call a refresh of view/state?

                }

        };

    }
    public EventHandler SwipeLeft(StateMachine c, Stage s, Database db){
        return (EventHandler<ActionEvent>) event -> {
            //TODO
            if (c.getState().equals(States.LoggedIn)){
                ProfileUser user = db.getLoggedInUser();
                ProfileUser otherUser = db.getPotentialUsers().get(0);

            }

        };

    }

    public EventHandler Back(StateMachine c, Stage s, Database db){
        return (EventHandler<ActionEvent>) event -> {
            //TODO
            if (c.getState().equals(States.Messaging)){

            }
            else if(c.getState().equals(States.Matches)){

            }
            else if(c.getState().equals(States.SelfProfile)){
            }



        };


    }

    public EventHandler SelfProfile(StateMachine c, Stage s, Database db){

        return (EventHandler<ActionEvent>) event ->{
            //TODO


        };


    }

    public EventHandler Matches(StateMachine c, Stage s, Database db){

        return (EventHandler<ActionEvent>) event ->{
        //TODO
        };
    }
    public EventHandler Message(StateMachine c, Stage s, Database db){

        return (EventHandler<ActionEvent>) event ->{
            //TODO
        };
    }
    public EventHandler Unmatch(StateMachine c, Stage s, Database db){

        return (EventHandler<ActionEvent>) event ->{
            //TODO
        };
    }

    public EventHandler Send(StateMachine c, Stage s, Database db){

        return (EventHandler<ActionEvent>) event ->{
            //TODO
        };
    }





}

