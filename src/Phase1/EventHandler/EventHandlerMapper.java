package Phase1.EventHandler;

import Phase1.DataAccess.DataBaseAccess;
import Phase1.Run.StateMachine;
import Phase1.States.Registration;
import Phase1.States.State;
import Phase1.Users.ProfileUser;
import Phase1.Views.*;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.text.View;
import java.util.ArrayList;

public class EventHandlerMapper {
    StateMachine c;
    Stage s;
    DataBaseAccess db;
    ViewBuilderFactory factory;
    public EventHandlerMapper(StateMachine c, Stage s, DataBaseAccess db){
        this.c = c;
        this.s = s;
        this.db = db;
        this.factory = new ViewBuilderFactory();
    }

    public void mapLogIn(LogInViewBuilder lb, RegistrationViewBuilder reg, SwipeViewBuilder sb){
        lb.getLogIn().setOnAction(EventHandlerFactory.LogInHandler(this.c, this.s, this.db));
        reg.getLogIn().setOnAction(EventHandlerFactory.LogInHandler(this.c, this.s, this.db));

    }

    public void mapCreateAccount(RegistrationViewBuilder reg){
        reg.createAccount().setOnAction(EventHandlerFactory.CreateAccount(this.c, this.s, reg, this.db));
    }

    public void mapLogOut(SwipeViewBuilder sb, LogInViewBuilder lb){
        sb.getLogOut().setOnAction(EventHandlerFactory.LogOutHandler(this.c, this.s, lb, this.db));
    }

    public void mapRegistration(LogInViewBuilder lb, RegistrationViewBuilder reg){
        lb.getCreateAccount().setOnAction(EventHandlerFactory.Registration(this.c, this.s, this.db));

    }

    public void mapMatches(SwipeViewBuilder sb, MatchesViewBuilder mb){
        sb.getMatches().setOnAction(EventHandlerFactory.Matches(this.c, this.s, mb, this.db));
    }

    public void mapBack(MatchesViewBuilder mb, ChatViewBuilder cv, SwipeViewBuilder sb, SelfViewBuilder ssb){
        mb.getBack().setOnAction(EventHandlerFactory.Back(this.c, this.s, mb, cv, sb));
        cv.getReturn().setOnAction(EventHandlerFactory.Back(this.c, this.s, mb, null, null));
        ssb.getBack().setOnAction(EventHandlerFactory.Back(this.c, this.s, mb, cv, sb));
    }

    public void mapMessage(ArrayList<Button> matches, ArrayList<ProfileUser> users, StateMachine c, Stage s,
                        MatchesViewBuilder mb, ChatViewBuilder cb, DataBaseAccess db, ProfileUser primary){
        for (int i = 0; i < matches.size(); i++) {
            matches.get(i).setOnAction(EventHandlerFactory.Message(c, s, cb, db, primary, users.get(i)));
        }

    }

    public void mapUnmatch(ChatViewBuilder cb, MatchesViewBuilder mb){
        cb.getUnmatch().setOnAction(EventHandlerFactory.Unmatch(this.c, this.s, this.db, cb.getId(), mb));


    }




}
