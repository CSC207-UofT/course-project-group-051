package Phase1.Views;

import Phase1.DataAccess.DataBaseAccess;
import Phase1.Users.ProfileUser;
import Phase1.Users.SwipeUser;
import Phase1.Users.User;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ViewBuilderFactory {
    public ViewBuilderFactory(){
    }

    public static ChatViewBuilder cBuilders(ProfileUser u, SwipeUser secondary){
            return new ChatViewBuilder(u.getfName(), u.getId(), secondary.getId());
        }

    public static LogInViewBuilder lBuilder(){
        return new LogInViewBuilder();
    }

    public static RegistrationViewBuilder rBuilder(){
        return new RegistrationViewBuilder();
    }

    public static SelfViewBuilder sBuilder(ProfileUser u){
        return new SelfViewBuilder(u);
    }

    public static SwipeViewBuilder svBuilder(ImageView image, SwipeUser u){
        return new SwipeViewBuilder(image, u);
    }
    
    public static MatchesViewBuilder mBuilder(ProfileUser u, ArrayList m, DataBaseAccess db){
        return new MatchesViewBuilder(u, m, db);
    }
    
}

