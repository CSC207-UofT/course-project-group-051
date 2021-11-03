package Phase1.Views;

import Phase1.Users.ProfileUser;
import Phase1.Users.User;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewBuilderFactory {
    public ViewBuilderFactory(){
    }

    public ChatViewBuilder cBuilders(ProfileUser u){
            return new ChatViewBuilder(u.getfName());
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
}

