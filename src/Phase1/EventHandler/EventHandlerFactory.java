package Phase1.EventHandler;

import Phase1.DataAccess.DataBaseAccess;
import Phase1.Run.StateMachine;
import Phase1.States.States;
import Phase1.UserActions.Actions;
import Phase1.Users.ProfileUser;
import Phase1.Users.SwipeUser;
import Phase1.Views.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class EventHandlerFactory {

    public EventHandlerFactory(){}

    public static ArrayList getMatches(int id, DataBaseAccess db){
        try{
        ArrayList<Integer> liked = db.getLikes(id);
        ArrayList<Integer> admirers = db.getAdmires(id);
        if (liked.isEmpty() || admirers.isEmpty()){
            return new ArrayList();
        }
        ArrayList<Integer> matches = new ArrayList();
        for (Integer i: liked){
            if (admirers.contains(i)){
                matches.add(i);
            }
        }
        return matches;
    }
    catch(Exception io){
            System.out.println(true);
    }
        return new ArrayList();
    }


    public static EventHandler<ActionEvent> LogInHandler(StateMachine c, Stage s, DataBaseAccess db,
                                                         LogInViewBuilder lb){
        return (EventHandler<ActionEvent>) event -> {

            if (c.getState().equals(States.LoggedOut)) {
                String username = lb.getUserName().getText();
                String password = lb.getPassword().getText();
                int id = db.logIn(username, password);
                if (id != -1) {
                    try{

                        ProfileUser u =  new ProfileUser(id, db.getFirstName(id), db.getLastName(id),
                            new Date(db.getBirthday(id)), username, password, db.getImgPath(id));
                        u.setBio(db.getBio(u.getId()));
                        u.setGender(db.getGender(u.getId()));
                        u.setPreference(db.getGenderPreference(u.getId()));
                        c.update(Actions.LOGIN, u, null);
                     ArrayList<Integer> swipelist = db.getSwipeList(id);

                        if(swipelist.isEmpty()){

                            EmptyMainViewBuilder eb = new EmptyMainViewBuilder(u);
                            eb.getLogOut().setOnAction(EventHandlerFactory.LogOutHandler(c, s, db));
                         ArrayList matches = new ArrayList<>();
                         if (!EventHandlerFactory.getMatches(u.getId(), db).isEmpty()){

                             matches = EventHandlerFactory.getMatches(u.getId(), db);

                         }

                         eb.getMatches().setOnAction(EventHandlerFactory.Matches(c, s, db, u,matches
                                ));
                         eb.getMe().setOnAction(EventHandlerFactory.SelfProfile(c, s, db, u));
                         eb.build(s);

                     }
                     else {
                         int nextid = swipelist.get(0);
                         SwipeUser user = new SwipeUser(nextid, db.getFirstName(nextid), db.getLastName(nextid),
                                 new Date(db.getBirthday(nextid)), db.getPassword(nextid), db.getImgPath(nextid));
                         FileInputStream f = new FileInputStream(db.getImgPath(nextid));
                         SwipeViewBuilder sb = new SwipeViewBuilder(new ImageView(new Image(f)), user);
                         sb.build(s);
                            ArrayList matches = new ArrayList();
                            if (!EventHandlerFactory.getMatches(u.getId(), db).isEmpty()){
                                matches = EventHandlerFactory.getMatches(u.getId(), db);

                            }

                            sb.getMatches().setOnAction(EventHandlerFactory.Matches(c, s, db, u,
                                 matches));
                     }}
                  //  catch (NumberFormatException io){
                    //    System.out.println("Invalid image path");
                    //}
                    catch (FileNotFoundException io){

                    }

                }


                else if(id == -1){
                    lb.invalidCredential();
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
                lb1.getLogIn().setOnAction(EventHandlerFactory.LogInHandler(c, s, db, lb1));
                lb1.getCreateAccount().setOnAction(EventHandlerFactory.Registration(c, s, db));
                lb1.build(s);
                s.show();

            }

        };}

    public static EventHandler RefreshHandler(StateMachine c, Stage s, DataBaseAccess db, ProfileUser user){

     return (EventHandler<ActionEvent>) event -> {
         if (c.getState().equals(States.LoggedIn)){
             ArrayList<Integer> potential = db.getSwipeList(user.getId());
             if (potential.isEmpty()){

             }
             else{
                 try{
                 int next = potential.get(0);
                 SwipeViewBuilder sb = new SwipeViewBuilder(new ImageView(new Image(new
                         FileInputStream(db.getImgPath(next)))),
                         new SwipeUser(next, db.getFirstName(next), db.getLastName(next),
                                 new Date(db.getBirthday(next)), db.getPassword(next), db.getImgPath(next)));
                 sb.build(s);
                 ArrayList matches = new ArrayList();
                 if(!EventHandlerFactory.getMatches(user.getId(), db).isEmpty()){
                     matches = EventHandlerFactory.getMatches(user.getId(), db);
                 }
                 sb.getMatches().setOnAction(EventHandlerFactory.Matches(c, s, db, user, matches));
                 sb.getMe().setOnAction(EventHandlerFactory.SelfProfile(c, s, db, user));
                 sb.getLogOut().setOnAction(EventHandlerFactory.LogOutHandler(c, s, db));
             }
             catch(Exception io){

             }
             }
         }
     };

    }

    public static EventHandler LogOutHandler(StateMachine c, Stage s, DataBaseAccess db){
        LogInViewBuilder lb = new LogInViewBuilder();
        return e -> {
            if (c.getState().equals(States.LoggedIn)) {
                lb.getLogIn().setOnAction(EventHandlerFactory.LogInHandler(c, s, db, lb));
                lb.getCreateAccount().setOnAction(EventHandlerFactory.Registration(c, s, db));
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
            rb.getLogIn().setOnAction(EventHandlerFactory.LogInHandler(c, s, db, new LogInViewBuilder()));
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
            String bio = rb.getBio().getText();

            try{
            if (DOB.equals("") || fName.equals("") || lName.equals("") || username.equals("") || location.equals("")){
                rb.fillIn();

            }


           else if (pw1.equals(pw2) && db.logIn(username, pw1) == -1){
               Date today = new Date();
               long diff = today.getTime() - new Date(DOB).getTime();
               int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
               FileInputStream file = new FileInputStream(location);
               int id = db.createUser(lName, fName, pw1, username, days / 365, gender, preference, DOB);
               db.setUsername(id, username);
               db.setBio(id, bio);
               db.setImgPath(id, location);
               rb.success(id);
               s.show();

            }
           else if(db.logIn(username, pw1) != -1){

             rb.accountExists();
             rb.getLogIn().setOnAction(EventHandlerFactory.LogInHandler(c, s, db, new LogInViewBuilder()));
             rb.createAccount().setOnAction(EventHandlerFactory.Registration(c,s,db));

            }

            else if (!pw1.equals(pw2)){
                rb.passwordDontMatch();
            }
        }

            catch(Exception e){
                rb.pathInvalid();
            }};

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
    public static EventHandler<ActionEvent> Save(StateMachine c, Stage s, DataBaseAccess db,
                                                 ProfileUser primary, SelfViewBuilder sb){

        return (EventHandler<ActionEvent>) event -> {
            if (c.getState().equals(States.SelfProfile)){
                c.update(Actions.VIEWSELF, primary, null);
                String fname = sb.getfName().getText();
                String lname = sb.getlName().getText();
                String dob = sb.getBirthday().getText();
                String pw = sb.getPW().getText();
                String image = sb.getImagePath().getText();
                String gender = sb.getGender().getText();
                String username = sb.getUsername().getText();
                String preference = sb.getPreference().getText();
                String bio = sb.getBio().getText();

                int id = primary.getId();
                db.setGender(id, gender);
                db.setGenderPreference(id, preference);
                db.setBirthday(id, dob);
                db.setPassword(id, pw);
                db.setFirstName(id, fname);
                db.setLastName(id, lname);
                sb.getBack().setOnAction(EventHandlerFactory.Back(c, s, db, primary, null));
                sb.getPW().setText(pw);
                sb.getBirthday().setText(dob);
                sb.getImagePath().setText(image);
                sb.getGender().setText(gender);
                sb.getPreference().setText(preference);
                sb.getfName().setText(fname);
                sb.getlName().setText(lname);
                primary.setfName(fname);
                primary.setLName(lname);
                primary.setPreference(preference);
                primary.setBio(bio);
                primary.setDOB(dob);
                primary.setGender(gender);
                primary.setPassword(pw);
                primary.setUsername(username);
                SelfViewBuilder sv = new SelfViewBuilder(primary);
                sv.build(s);
                sv.getSave().setOnAction(EventHandlerFactory.Save(c, s, db, primary, sv));
                sv.getBack().setOnAction(EventHandlerFactory.Back(c, s, db, primary, null));
                try{db.setImgPath(primary.getId(), image);}
                catch(Exception io){
                    sb.invalidPath();
                }


            }

        };


    }



        public static EventHandler<ActionEvent> Back(StateMachine c, Stage s, DataBaseAccess db,
                                                 ProfileUser primary, ChatViewBuilder cv){
        return (EventHandler<ActionEvent>) event -> {
            if (c.getState().equals(States.Messaging)){
                ArrayList matches = new ArrayList();
                if (!EventHandlerFactory.getMatches(primary.getId(), db).isEmpty()){
                    matches = EventHandlerFactory.getMatches(primary.getId(), db);
                }

                c.update(Actions.BACK, primary, null);
                MatchesViewBuilder mb1 = new MatchesViewBuilder(primary, matches, db);
                mb1.build(s);

            }
            else if(c.getState().equals(States.Matches) || c.getState().equals(States.SelfProfile)){
                int id = primary.getId();
                ArrayList<Integer> swipelist = db.getSwipeList(id);
                if (swipelist.isEmpty()){
                    c.update(Actions.BACK, primary, null);
                    EmptyMainViewBuilder eb = new EmptyMainViewBuilder(primary);
                    try{
                    ArrayList list = new ArrayList();
                    if (!EventHandlerFactory.getMatches(id, db).isEmpty()){
                        list = EventHandlerFactory.getMatches(id, db);
                    }
                    eb.getMatches().setOnAction(EventHandlerFactory.Matches(c, s, db, primary, list));
                    eb.getRefresh().setOnAction(EventHandlerFactory.RefreshHandler(c, s, db, primary));
                    eb.getMe().setOnAction(EventHandlerFactory.SelfProfile(c, s, db, primary));
                    eb.getLogOut().setOnAction(EventHandlerFactory.LogOutHandler(c, s, db));
                    eb.build(s);
                }
                    catch(NumberFormatException e){
                    }
                }
                else{
                int nextid = swipelist.get(0);
                try {
                    FileInputStream f = new FileInputStream(db.getImgPath(nextid));
                    Image image = new Image(f);
                    ImageView iv = new ImageView(image);
                    SwipeViewBuilder sb = new SwipeViewBuilder(iv, new SwipeUser(nextid, db.getFirstName(nextid),
                            db.getLastName(nextid), new Date(db.getBirthday(nextid)), db.getPassword(nextid),
                            db.getImgPath(nextid)));
                    c.update(Actions.BACK, null, null);
                    sb.build(s);
                    swipelist.remove(nextid);
                }
                catch (NumberFormatException e){

                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }



            }

        };};
    }




    public static EventHandler<ActionEvent> SelfProfile(StateMachine c, Stage s, DataBaseAccess db, ProfileUser user){
        SelfViewBuilder sb = new SelfViewBuilder(user);
        return (EventHandler<ActionEvent>) event ->{
            if(c.getState().equals(States.LoggedIn)){
                c.update(Actions.VIEWSELF, user, null);
                sb.build(s);
                sb.getBack().setOnAction(EventHandlerFactory.Back(c,s,db, user,null));
                sb.getSave().setOnAction(EventHandlerFactory.Save(c, s, db, user, sb));
            }


        };


    }

    public static EventHandler<ActionEvent> Matches(StateMachine c, Stage s, DataBaseAccess db, ProfileUser user,
                                                    ArrayList<Integer> matches){

        MatchesViewBuilder mb = new MatchesViewBuilder(user, matches, db);

        ArrayList<Button> matchesButtons= mb.matchButtons(db);
        return (EventHandler<ActionEvent>) event ->{
            if (c.getState().equals(States.LoggedIn)){
            c.update(Actions.SHOWMATCHES, user, null);
            mb.build(s);
            mb.getBack().setOnAction(EventHandlerFactory.Back(c, s, db, user, null));
            for (int i = 0; i < matchesButtons.size(); i++){
                int id = matches.get(i);
                ProfileUser u = new ProfileUser(id, db.getFirstName(id), db.getLastName(id),
                        new Date(db.getBirthday(id)), user.getUsername(), db.getImgPath(id), db.getPassword(id));
                u.setBio(db.getBio(u.getId()));
                u.setGender(db.getGender(u.getId()));
                u.setPreference(db.getGenderPreference(u.getId()));
                    matchesButtons.get(i).setOnAction(EventHandlerFactory.Message(c, s, db, user, u, matches));

            }

        }};

    }
    public static EventHandler<ActionEvent> Message(StateMachine c, Stage s, DataBaseAccess db, ProfileUser primary,
                                                    ProfileUser secondary, ArrayList<Integer> matches){
        ChatViewBuilder cb = new ChatViewBuilder(secondary.getfName(), primary.getId(), secondary.getId());
        return (EventHandler<ActionEvent>) event ->{
            if (c.getState().equals(States.Matches)){
                c.update(Actions.MESSAGE, primary, secondary);
                cb.build(s);
                cb.getUnmatch().setOnAction(EventHandlerFactory.Unmatch(c, s, db, primary, matches, secondary.getId()));
                cb.getReturn().setOnAction(EventHandlerFactory.Matches(c, s, db, primary, matches));
            }
        };
    }
    public static EventHandler<ActionEvent> Unmatch(StateMachine c, Stage s, DataBaseAccess db, ProfileUser primary,
                                                    ArrayList<Integer> matches, int secondary){
        return (EventHandler<ActionEvent>) event ->{
            if(c.getState().equals(States.Messaging)){
                MatchesViewBuilder mb = new MatchesViewBuilder(primary, matches, db);
                db.unlikeUser(primary.getId(), secondary);
                c.update(Actions.UNMATCH, null, null);
                mb.build(s);
                mb.pop(secondary);
                mb.getBack().setOnAction(EventHandlerFactory.Back(c, s, db, primary, null));
                ArrayList<Button> matchButtons = mb.matchButtons(db);
                for (int i = 0; i < matchButtons.size(); i++){


                }
            }
        };
    }

    public static EventHandler<ActionEvent> Send(StateMachine c, Stage s, DataBaseAccess db){

        return (EventHandler<ActionEvent>) event ->{
            //TODO
        };
    }





}

