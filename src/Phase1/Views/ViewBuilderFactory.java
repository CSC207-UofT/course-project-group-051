package Phase1.Views;

import Phase1.Users.ProfileUser;
import Phase1.Users.User;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ViewBuilderFactory {
    public ViewBuilderFactory(){
    }

    public ChatViewBuilder cBuilders(ProfileUser u){
            return new ChatViewBuilder(u.getfName(), u.getId());
        }

    public LogInViewBuilder lBuilder(){
        return new LogInViewBuilder();
    }

    public RegistrationViewBuilder rBuilder(){
        return new RegistrationViewBuilder();
    }

    public SelfViewBuilder sBuilder(ProfileUser u){
        return new SelfViewBuilder(u);
    }

    public SwipeViewBuilder svBuilder(ImageView image, ProfileUser u){
        return new SwipeViewBuilder(image, u);
    }
    
    public MatchesViewBuilder mBuilder(ProfileUser u, ArrayList m){
        return new MatchesViewBuilder(u, m);
    }
    
}

