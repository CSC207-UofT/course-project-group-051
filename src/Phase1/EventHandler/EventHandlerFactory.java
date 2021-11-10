package Phase1.EventHandler;

import Phase1.DataAccess.DataBaseAccess;
import Phase1.Run.StateMachine;
import Phase1.States.Registration;
import Phase1.States.States;
import Phase1.UserActions.Actions;
import Phase1.Users.ProfileUser;
import Phase1.Views.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class EventHandlerFactory {

    public EventHandlerFactory(){}


    public static EventHandler<ActionEvent> LogInHandler(StateMachine c, Stage s, DataBaseAccess db){
        return (EventHandler<ActionEvent>) event -> {
            System.out.println(c.getState());
            LogInViewBuilder lb = new LogInViewBuilder();
            lb.build(s);


            if (c.getState().equals(States.LoggedOut)) {
                String username = lb.getUserName();
                String password = lb.getPassword();
                int id = db.logIn(username, password);
                if (id != -1) {
                    // c.update(Actions.LOGIN, new ProfileUser(id, db.getFirstName(id), db.getLastName(id),
                    //       db.getBirthDate(id), password, new ImageView(db.getImage(id)));
                }
                // ArrayList potentialMatches = db.getPotentialMatches(u);
                //if (!potentialMatches.isEmpty()) {
                //  SwipeViewBuilder sb1 = new SwipeViewBuilder(potentialMatches.get(0),
                //        potentialMatches.get(0).getImage());
                // potentialMatches.remove(potentialMatches.get(0));
            }
           else if(c.getState().equals(States.Registration)){

                c.update(Actions.LOGIN, null, null);
                    System.out.println(c.getState());
                LogInViewBuilder lb1 = new LogInViewBuilder();
                RegistrationViewBuilder reg1 = new RegistrationViewBuilder();
                lb1.getLogIn().setOnAction(EventHandlerFactory.LogInHandler(c, s, db));
                lb1.getCreateAccount().setOnAction(EventHandlerFactory.Registration(c, s, db));
                lb1.build(s);
                s.show();

            }






        };}

    public static EventHandler LogOutHandler(StateMachine c, Stage s, LogInViewBuilder lb, DataBaseAccess db){
        return e -> {
            if (c.getState().equals(States.LoggedIn)) {
                c.update(Actions.LOGOUT, null, null);
                lb.build(s);

            }
        };}




    public static EventHandler<ActionEvent> Registration(StateMachine c, Stage s, DataBaseAccess db){
        return (EventHandler<ActionEvent>) event -> {
            if(c.getState().equals(States.LoggedOut)){
            c.update(Actions.REGISTER, null, null);
            RegistrationViewBuilder rb = new RegistrationViewBuilder();
            rb.build(s);
            rb.getLogIn().setOnAction(EventHandlerFactory.LogInHandler(c, s, db));
            rb.createAccount().setOnAction(EventHandlerFactory.CreateAccount(c, s, rb, db));
            }
                  };
    }
    public static EventHandler<ActionEvent> CreateAccount(StateMachine c, Stage s, RegistrationViewBuilder rb, DataBaseAccess db){

        return (EventHandler<ActionEvent>) event -> {

            String DOB = rb.getDOB().getText();
            String fName = rb.getFirstName().getText();
            String lName = rb.getLastName().getText();
            String username = rb.userName().getText();
            String pw1 = rb.getPassword().getText();
            String pw2 = rb.getPassword1().getText();
            String gender = rb.getGender().getText();
            String preference = rb.getPreference().getText();
            String location = rb.getPicturePath().getText();
            if (DOB.equals("") || fName.equals("") || lName.equals("") || username.equals("") || location.equals("")){
                rb.fillIn();

            }


           else if (pw1.equals(pw2) ){// !db.userExists(username)) {
                db.createUser(lName, fName, pw1, username, 19, gender, preference, "Dec,06,1999");
                rb.success();
                s.show();
            }
           // else if(db.userExists(username)){

             //   rb.accountExists();
            //}

            else if (!pw1.equals(pw2)){
                rb.passwordDontMatch();
            }
        };
    }

    public static EventHandler<ActionEvent> SwipeRight(StateMachine c, Stage s, DataBaseAccess db){
        return (EventHandler<ActionEvent>) event -> {
            //TODO
                if (c.getState().equals(States.LoggedIn)){
                  //  ProfileUser user = db.getLoggedInUser();
                  //  ProfileUser otherUser = db.getPotentialUsers().get(0);
                    // get user
                    // test

                }

        };

    }
    public static EventHandler<ActionEvent> SwipeLeft(StateMachine c, Stage s, DataBaseAccess db){
        return (EventHandler<ActionEvent>) event -> {
            //TODO
            if (c.getState().equals(States.LoggedIn)){
                //ProfileUser user = db.getLoggedInUser();
                //ProfileUser otherUser = db.getPotentialUsers().get(0);

            }

        };

    }

    public static EventHandler<ActionEvent> Back(StateMachine c, Stage s, MatchesViewBuilder mb, ChatViewBuilder cv, SwipeViewBuilder sb){
        return (EventHandler<ActionEvent>) event -> {
            if (c.getState().equals(States.Messaging)){
                c.update(Actions.BACK, null, null);
                mb.build(s);

            }
            else if(c.getState().equals(States.Matches) || c.getState().equals(States.SelfProfile)){
                c.update(Actions.BACK, null, null);
                sb.build(s);

            }
        };


    }

    public static EventHandler<ActionEvent> SelfProfile(StateMachine c, Stage s, SelfViewBuilder sb, DataBaseAccess db){

        return (EventHandler<ActionEvent>) event ->{
            if(c.getState().equals(States.LoggedIn)){
                c.update(Actions.VIEWSELF, null, null);
                sb.build(s);
            }


        };


    }

    public static EventHandler<ActionEvent> Matches(StateMachine c, Stage s, MatchesViewBuilder mb, DataBaseAccess db){

        return (EventHandler<ActionEvent>) event ->{
            if (c.getState().equals(States.LoggedIn)){
            c.update(Actions.SHOWMATCHES, null, null);
            mb.build(s);}
        };
    }
    public static EventHandler<ActionEvent> Message(StateMachine c, Stage s, ChatViewBuilder cb, DataBaseAccess db, ProfileUser primary,
                                                    ProfileUser secondary){

        return (EventHandler<ActionEvent>) event ->{
            if (c.getState().equals(States.Matches)){
                c.update(Actions.MESSAGE, primary, secondary);
                cb.build(s);
            }
        };
    }
    public static EventHandler<ActionEvent> Unmatch(StateMachine c, Stage s, DataBaseAccess db, int id, MatchesViewBuilder mb){

        return (EventHandler<ActionEvent>) event ->{
            if(c.getState().equals(States.Messaging)){
                c.update(Actions.UNMATCH, null, null);
                mb.build(s);
            }
        };
    }

    public static EventHandler<ActionEvent> Send(StateMachine c, Stage s, DataBaseAccess db){

        return (EventHandler<ActionEvent>) event ->{
            //TODO
        };
    }





}

