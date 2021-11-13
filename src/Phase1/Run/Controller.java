package Phase1.Run;

import Phase1.DataAccess.DataAccessMechanism;
import Phase1.DataAccess.DataAccessMechanism;
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

public class Controller {
    public Controller(){
    }


    public static EventHandler<ActionEvent> LogInHandler(StateMachine c, Stage s, DataAccessMechanism dm,
                                                         LogInViewBuilder lb){
        return (EventHandler<ActionEvent>) event -> {

            if (c.getState().equals(States.LoggedOut)) {
                String username = lb.getUserName().getText();
                String password = lb.getPassword().getText();
                int id = dm.logIn(username, password);
                if (id != -1) {
                    try{
                        ProfileUser u =  new ProfileUser(id, dm.getFirstName(id), dm.getLastName(id),
                            new Date(dm.getBirthday(id)), username, password, dm.getImgPath(id));
                        u.setBio(dm.getBio(u.getId()));
                        u.setGender(dm.getGender(u.getId()));
                        u.setPreference(dm.getGenderPreference(u.getId()));
                        c.update(Actions.LOGIN, u, null);
                     ArrayList<Integer> swipelist = dm.getSwipeList(id);
                        if(swipelist.isEmpty()){

                            EmptyMainViewBuilder eb = new EmptyMainViewBuilder(u);
                            eb.getLogOut().setOnAction(Controller.LogOutHandler(c, s, dm));
                         ArrayList matches = new ArrayList<>();
                         if (!dm.getMatches(u.getId()).isEmpty()){

                             matches = dm.getMatches(u.getId());

                         }

                         eb.getMatches().setOnAction(Controller.Matches(c, s, dm, u,matches
                                ));
                         eb.getMe().setOnAction(Controller.SelfProfile(c, s, dm, u));
                         eb.build(s);

                     }
                     else {
                         System.out.println(true);

                         int nextid = swipelist.get(0);
                         swipelist.remove(0);

                            SwipeUser user = new SwipeUser(nextid, dm.getFirstName(nextid), dm.getLastName(nextid),
                                 new Date(dm.getBirthday(nextid)), dm.getPassword(nextid), dm.getImgPath(nextid));
                         user.setBio(dm.getBio(user.getId()));
                         FileInputStream f = new FileInputStream(dm.getImgPath(nextid));
                         SwipeViewBuilder sb = new SwipeViewBuilder(new ImageView(new Image(f)), user);
                         sb.build(s);
                            ArrayList matches = new ArrayList();
                            if (!dm.getMatches(u.getId()).isEmpty()){
                                matches = dm.getMatches(u.getId());

                            }

                            sb.getMatches().setOnAction(Controller.Matches(c, s, dm, u,
                                 matches));
                            sb.getLogOut().setOnAction(Controller.LogOutHandler(c, s, dm));
                            sb.getMe().setOnAction(Controller.SelfProfile(c, s, dm, u));
                           sb.getRight().setOnAction(Controller.SwipeRight(c, s, dm, swipelist, u));
                           sb.getLeft().setOnAction(Controller.SwipeLeft(c, s, dm, swipelist, u));
                     }}
                  //  catch (NumberFormatException io){
                    //    System.out.println("Invalid image path");
                    //}
                    catch (FileNotFoundException io){
                        lb.invalidCredential();

                    }

                }


                else if(id == -1){
                    lb.invalidCredential();
                }
                // ArrayList potentialMatches = dm.getPotentialMatches(u);
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
                lb1.getLogIn().setOnAction(Controller.LogInHandler(c, s, dm, lb1));
                lb1.getCreateAccount().setOnAction(Controller.Registration(c, s, dm));
                lb1.build(s);
                s.show();

            }

        };}

    public static EventHandler RefreshHandler(StateMachine c, Stage s, DataAccessMechanism dm, ProfileUser user){

     return (EventHandler<ActionEvent>) event -> {
         if (c.getState().equals(States.LoggedIn)){
             ArrayList<Integer> potential = dm.getSwipeList(user.getId());

             if (potential.isEmpty()){
                EmptyMainViewBuilder eb = new EmptyMainViewBuilder(user);
                eb.getRefresh().setOnAction(Controller.RefreshHandler(c, s, dm, user));
                eb.getMe().setOnAction(Controller.SelfProfile(c, s, dm, user));
                eb.getMatches().setOnAction(Controller.Matches(c, s, dm, user, dm.getMatches(user.getId())));
                eb.getLogOut().setOnAction(Controller.LogOutHandler(c,s,dm));
                eb.build(s);
             }
             else{
                 try{
                 int next = potential.get(0);
                 potential.remove(0);
                     SwipeUser u = new SwipeUser(next, dm.getFirstName(next), dm.getLastName(next),
                             new Date(dm.getBirthday(next)), dm.getPassword(next), dm.getImgPath(next));
                     u.setBio(dm.getBio(u.getId()));
                 SwipeViewBuilder sb = new SwipeViewBuilder(new ImageView(new Image(new
                         FileInputStream(dm.getImgPath(next)))), u);

                 ArrayList matches = new ArrayList();
                 if(!dm.getMatches(user.getId()).isEmpty()){
                     matches = dm.getMatches(user.getId());
                 }
                 sb.getMatches().setOnAction(Controller.Matches(c, s, dm, user, matches));
                 sb.getMe().setOnAction(Controller.SelfProfile(c, s, dm, user));
                 sb.getLogOut().setOnAction(Controller.LogOutHandler(c, s, dm));
                 sb.getLeft().setOnAction(Controller.SwipeLeft(c, s, dm, potential, user));
                 sb.getRight().setOnAction(Controller.SwipeRight(c, s, dm, potential, user));
                 sb.build(s);

                 }
             catch(Exception io){
                System.out.println("Invalid image path for the SwipeUser");
             }
             }
         }
     };

    }

    public static EventHandler LogOutHandler(StateMachine c, Stage s, DataAccessMechanism dm){
        LogInViewBuilder lb = new LogInViewBuilder();
        return e -> {
            if (c.getState().equals(States.LoggedIn)) {
                lb.getLogIn().setOnAction(Controller.LogInHandler(c, s, dm, lb));
                lb.getCreateAccount().setOnAction(Controller.Registration(c, s, dm));
                c.update(Actions.LOGOUT, null, null);
                lb.build(s);

            }
        };}




    public static EventHandler<ActionEvent> Registration(StateMachine c, Stage s, DataAccessMechanism dm){
        return (EventHandler<ActionEvent>) event -> {
            if(c.getState().equals(States.LoggedOut)){
            c.update(Actions.REGISTER, null, null);
            RegistrationViewBuilder rb = new RegistrationViewBuilder();
            rb.build(s);
            rb.getLogIn().setOnAction(Controller.LogInHandler(c, s, dm, new LogInViewBuilder()));
            rb.createAccount().setOnAction(Controller.CreateAccount(c, s, rb, dm));
            }
                  };
    }
    public static EventHandler<ActionEvent> CreateAccount(StateMachine c, Stage s, RegistrationViewBuilder rb,
                                                          DataAccessMechanism dm){

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


           else if (pw1.equals(pw2) && dm.logIn(username, pw1) == -1){
               Date today = new Date();
               long diff = today.getTime() - new Date(DOB).getTime();
               int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
               FileInputStream file = new FileInputStream(location);
               int id = dm.createUser(lName, fName, pw1, username, days / 365, gender, preference, DOB);
               dm.setUsername(id, username);
               dm.setBio(id, bio);
               dm.setImgPath(id, location);
               rb.success(id);
               s.show();

            }
           else if(dm.logIn(username, pw1) != -1){

             rb.accountExists();
             rb.getLogIn().setOnAction(Controller.LogInHandler(c, s, dm, new LogInViewBuilder()));
             rb.createAccount().setOnAction(Controller.Registration(c,s,dm));

            }

            else if (!pw1.equals(pw2)){
                rb.passwordDontMatch();
            }
        }

            catch(Exception e){
                rb.pathInvalid();
            }};

    }

    public static EventHandler<ActionEvent> SwipeRight(StateMachine c, Stage s, DataAccessMechanism dm, ArrayList swipelist,
                                                       ProfileUser u){
        return (EventHandler<ActionEvent>) event -> {
                if (c.getState().equals(States.LoggedIn)){
                    if(swipelist.isEmpty()){
                        EmptyMainViewBuilder eb = new EmptyMainViewBuilder(u);
                        eb.getLogOut().setOnAction(Controller.LogOutHandler(c,s,dm));
                        eb.getMe().setOnAction(Controller.SelfProfile(c,s,dm,u));
                        eb.getMatches().setOnAction(Controller.Matches(c,s,dm,u,dm.getMatches(u.getId())));
                        eb.getRefresh().setOnAction(Controller.RefreshHandler(c,s,dm,u));
                        eb.build(s);

                    }
                    else{
                        try {
                            FileInputStream f = new FileInputStream(u.getImagePath());
                            Image image = new Image(f);
                            ImageView i = new ImageView(image);
                            int id = (Integer)swipelist.get(0);
                            swipelist.remove(0);
                            SwipeUser sw = new SwipeUser(id, dm.getFirstName(id), dm.getLastName(id),
                                    new Date(dm.getBirthday(id)), dm.getPassword(id), dm.getImgPath(id));
                            SwipeViewBuilder sb = new SwipeViewBuilder(i, sw);
                            dm.likeUser(u.getId(), id);
                            System.out.println(dm.getAdmires(id));
                            sb.getMe().setOnAction(Controller.SelfProfile(c, s, dm, u));
                            sb.getRight().setOnAction(Controller.SwipeRight(c, s, dm, swipelist, u));
                            sb.getLeft().setOnAction(Controller.SwipeLeft(c,s,dm,swipelist, u));
                            sb.getMatches().setOnAction(Controller.Matches(c,s,dm,u,dm.getMatches(u.getId())));
                            sb.getLogOut().setOnAction(Controller.LogOutHandler(c, s, dm));
                            sb.build(s);
                        }
                        catch(Exception i){
                            System.out.println("SwipeUser image path invalid.");

                        }

                    }
                  //  ProfileUser user = dm.getLoggedInUser();
                  //  ProfileUser otherUser = dm.getPotentialUsers().get(0);
                    // get user
                    // test

                }

        };

    }
    public static EventHandler<ActionEvent> SwipeLeft(StateMachine c, Stage s, DataAccessMechanism dm, ArrayList swipelist,
                                                      ProfileUser u){
        return (EventHandler<ActionEvent>) event -> {
            //TODO
            if (c.getState().equals(States.LoggedIn)){
                if(swipelist.isEmpty()){
                    EmptyMainViewBuilder eb = new EmptyMainViewBuilder(u);
                    eb.getLogOut().setOnAction(Controller.LogOutHandler(c,s,dm));
                    eb.getMe().setOnAction(Controller.SelfProfile(c,s,dm,u));
                    eb.getMatches().setOnAction(Controller.Matches(c,s,dm,u,dm.getMatches(u.getId())));
                    eb.getRefresh().setOnAction(Controller.RefreshHandler(c,s,dm,u));
                    eb.build(s);

                }
                else{
                    try {
                        FileInputStream f = new FileInputStream(u.getImagePath());
                        Image image = new Image(f);
                        ImageView i = new ImageView(image);
                        int id = (Integer)swipelist.get(0);
                        swipelist.remove(0);
                        SwipeUser sw = new SwipeUser(id, dm.getFirstName(id), dm.getLastName(id),
                                new Date(dm.getBirthday(id)),
                                dm.getPassword(id), dm.getImgPath(id));
                        SwipeViewBuilder sb = new SwipeViewBuilder(i, sw);
                        dm.unlikeUser(u.getId(), id);
                        sb.getMe().setOnAction(Controller.SelfProfile(c, s, dm, u));
                        sb.getRight().setOnAction(Controller.SwipeRight(c, s, dm, swipelist, u));
                        sb.getLeft().setOnAction(Controller.SwipeLeft(c,s,dm,swipelist, u));
                        sb.getMatches().setOnAction(Controller.Matches(c,s,dm,u,dm.getMatches(u.getId())));
                        sb.getLogOut().setOnAction(Controller.LogOutHandler(c, s, dm));
                    }
                    catch(Exception i){
                        System.out.println("SwipeUser image path invalid.");


                    }

                }
                //  ProfileUser user = dm.getLoggedInUser();
                //  ProfileUser otherUser = dm.getPotentialUsers().get(0);
                // get user
                // test

            }

        };

    }
    public static EventHandler<ActionEvent> Save(StateMachine c, Stage s, DataAccessMechanism dm,
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
                dm.setGender(id, gender);
                dm.setGenderPreference(id, preference);
                dm.setBirthday(id, dob);
                dm.setPassword(id, pw);
                dm.setFirstName(id, fname);
                dm.setLastName(id, lname);
                dm.setBio(id, bio);
                SelfViewBuilder sv = new SelfViewBuilder(primary);
                sv.getSave().setOnAction(Controller.Save(c, s, dm, primary, sv));
                sv.getBack().setOnAction(Controller.Back(c, s, dm, primary, null));
                sv.getBack().setOnAction(Controller.Back(c, s, dm, primary, null));
                sv.getBirthday().setText(dob);
                sv.getPW().setText(pw);
                sv.getBirthday().setText(dob);
                sv.getImagePath().setText(image);
                sv.getGender().setText(gender);
                sv.getPreference().setText(preference);
                sv.getfName().setText(fname);
                sv.getlName().setText(lname);
                sv.getBio().setText(bio);

                primary.setfName(fname);
                primary.setLName(lname);
                primary.setPreference(preference);
                primary.setBio(bio);
                primary.setDOB(dob);
                primary.setGender(gender);
                primary.setPassword(pw);
                primary.setUsername(username);
                sv.build(s);

                try{dm.setImgPath(primary.getId(), image);}
                catch(Exception io){
                    sb.invalidPath();
                }


            }

        };


    }



        public static EventHandler<ActionEvent> Back(StateMachine c, Stage s, DataAccessMechanism dm,
                                                 ProfileUser primary, ChatViewBuilder cv){
        return (EventHandler<ActionEvent>) event -> {
            if (c.getState().equals(States.Messaging)){
                ArrayList matches = new ArrayList();
                if (!dm.getMatches(primary.getId()).isEmpty()){
                    matches = dm.getMatches(primary.getId());
                }

                c.update(Actions.BACK, primary, null);
                MatchesViewBuilder mb1 = new MatchesViewBuilder(primary, matches, dm);
                mb1.build(s);

            }

            else //if(c.getState().equals(States.SelfProfile) || c.getState().equals(States.Matches))
                 {
                int id = primary.getId();
                c.update(Actions.BACK, primary, null);
                ArrayList<Integer> swipelist = dm.getSwipeList(id);
                if (swipelist.isEmpty()){
                    c.update(Actions.BACK, primary, null);
                    EmptyMainViewBuilder eb = new EmptyMainViewBuilder(primary);
                    try{
                    ArrayList list = new ArrayList();
                    if (!dm.getMatches(id).isEmpty()){
                        list = dm.getMatches(id);
                    }
                    eb.getMatches().setOnAction(Controller.Matches(c, s, dm, primary, list));
                    eb.getRefresh().setOnAction(Controller.RefreshHandler(c, s, dm, primary));
                    eb.getMe().setOnAction(Controller.SelfProfile(c, s, dm, primary));
                    eb.getLogOut().setOnAction(Controller.LogOutHandler(c, s, dm));
                    eb.build(s);
                }
                    catch(NumberFormatException e){
                        System.out.println("SwipeUser image path invalid.");

                    }
                }
                else{
                    ArrayList matches = dm.getMatches(primary.getId());
                int nextid = swipelist.get(0);
                    swipelist.remove(0);

                    try {
                    FileInputStream f = new FileInputStream(dm.getImgPath(nextid));
                    Image image = new Image(f);
                    ImageView iv = new ImageView(image);
                    SwipeUser u = new SwipeUser(nextid, dm.getFirstName(nextid),
                            dm.getLastName(nextid), new Date(dm.getBirthday(nextid)), dm.getPassword(nextid),
                            dm.getImgPath(nextid));
                    u.setBio(dm.getBio(u.getId()));
                    SwipeViewBuilder sb = new SwipeViewBuilder(iv, u);
                    c.update(Actions.BACK, null, null);
                    sb.getLogOut().setOnAction(Controller.LogOutHandler(c, s, dm));
                    sb.getMatches().setOnAction(Controller.Matches(c,s,dm, primary, matches));
                    sb.getMe().setOnAction(Controller.SelfProfile(c, s, dm, primary));
                    sb.getRight().setOnAction(Controller.SwipeRight(c, s, dm, swipelist, primary));
                    sb.getLeft().setOnAction(Controller.SwipeLeft(c, s, dm, swipelist, primary));

                    sb.build(s);

                }
                catch (FileNotFoundException e) {
                    System.out.println("SwipeUser image path invalid.");
                }



            }

        };};
    }




    public static EventHandler<ActionEvent> SelfProfile(StateMachine c, Stage s, DataAccessMechanism dm, ProfileUser user){
        SelfViewBuilder sb = new SelfViewBuilder(user);
        return (EventHandler<ActionEvent>) event ->{
            if(c.getState().equals(States.LoggedIn)){
                c.update(Actions.VIEWSELF, user, null);
                sb.build(s);
                sb.getBack().setOnAction(Controller.Back(c,s,dm, user,null));
                sb.getSave().setOnAction(Controller.Save(c, s, dm, user, sb));
            }


        };


    }

    public static EventHandler<ActionEvent> Matches(StateMachine c, Stage s, DataAccessMechanism dm, ProfileUser user,
                                                    ArrayList<Integer> matches){

        MatchesViewBuilder mb = new MatchesViewBuilder(user, matches, dm);
        System.out.println(dm.getMatches(user.getId()));
        System.out.println(dm.getAdmires(user.getId()));

        ArrayList<Button> matchesButtons= mb.matchButtons(dm);
        return (EventHandler<ActionEvent>) event ->{
            if (c.getState().equals(States.LoggedIn)){
            c.update(Actions.SHOWMATCHES, user, null);
            mb.build(s);
            mb.getBack().setOnAction(Controller.Back(c, s, dm, user, null));
            for (int i = 0; i < matchesButtons.size(); i++){
                int id = matches.get(i);
                ProfileUser u = new ProfileUser(id, dm.getFirstName(id), dm.getLastName(id),
                        new Date(dm.getBirthday(id)), user.getUsername(), dm.getImgPath(id), dm.getPassword(id));
                u.setBio(dm.getBio(u.getId()));
                u.setGender(dm.getGender(u.getId()));
                u.setPreference(dm.getGenderPreference(u.getId()));
                    matchesButtons.get(i).setOnAction(Controller.Message(c, s, dm, user, u, matches));

            }

        }};

    }
    public static EventHandler<ActionEvent> Message(StateMachine c, Stage s, DataAccessMechanism dm, ProfileUser primary,
                                                    ProfileUser secondary, ArrayList<Integer> matches){
        ChatViewBuilder cb = new ChatViewBuilder(secondary.getfName(), primary.getId(), secondary.getId());
        return (EventHandler<ActionEvent>) event ->{
            if (c.getState().equals(States.Matches)){
                c.update(Actions.MESSAGE, primary, secondary);
                cb.build(s);
                cb.getUnmatch().setOnAction(Controller.Unmatch(c, s, dm, primary, matches, secondary.getId()));
                cb.getReturn().setOnAction(Controller.Matches(c, s, dm, primary, matches));
            }
        };
    }
    public static EventHandler<ActionEvent> Unmatch(StateMachine c, Stage s, DataAccessMechanism dm, ProfileUser primary,
                                                    ArrayList<Integer> matches, int secondary){
        return (EventHandler<ActionEvent>) event ->{
            if(c.getState().equals(States.Messaging)){
                MatchesViewBuilder mb = new MatchesViewBuilder(primary, matches, dm);
                dm.unlikeUser(primary.getId(), secondary);
                c.update(Actions.UNMATCH, null, null);
                mb.build(s);
                mb.pop(secondary);
                mb.getBack().setOnAction(Controller.Back(c, s, dm, primary, null));
                ArrayList<Button> matchButtons = mb.matchButtons(dm);
                for (int i = 0; i < matchButtons.size(); i++){


                }
            }
        };
    }

    public static EventHandler<ActionEvent> Send(StateMachine c, Stage s, DataAccessMechanism dm){

        return (EventHandler<ActionEvent>) event ->{
            //TODO
        };
    }





}

