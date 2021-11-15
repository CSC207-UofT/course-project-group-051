package Phase1.Views;

import Phase1.DataAccess.DataBaseAccess;
import Phase1.Users.ProfileUser;
import Phase1.Users.SwipeUser;
import Phase1.Users.User;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ViewBuilderFactory {
    /**
     * A class utilizing factory design pattern that returns the builder of each type.
     */
    public ViewBuilderFactory(){
    }

    /**
     * @param u the user currently logged in
     * @param secondary the user that is being messaged to
     * @return the chatview builder for the users
     */
    public static ChatViewBuilder cBuilders(ProfileUser u, SwipeUser secondary){
            return new ChatViewBuilder(u.getfName(), u.getId(), secondary.getId());
        }

    /**
     * @return the log in view builder
     */
    public static LogInViewBuilder lBuilder(){
        return new LogInViewBuilder();
    }

    /**
     * @return the registration view builder
     */
    public static RegistrationViewBuilder rBuilder(){
        return new RegistrationViewBuilder();
    }

    /**
     * @param u the current user
     * @return the self view builder for the user
     */
    public static SelfViewBuilder sBuilder(ProfileUser u){
        return new SelfViewBuilder(u);
    }

    /**
     * @param image imageview of the swipe user
     * @param u the swipe user
     * @return the swipe user builder
     */
    public static SwipeViewBuilder svBuilder(ImageView image, SwipeUser u){
        return new SwipeViewBuilder(image, u);
    }

    /**
     * @param u the current user
     * @param m the list of matches
     * @param db the database
     * @return the matchviewbuilder for the current user
     */
    public static MatchesViewBuilder mBuilder(ProfileUser u, ArrayList m, DataBaseAccess db){
        return new MatchesViewBuilder(u, m, db);
    }
    
}

