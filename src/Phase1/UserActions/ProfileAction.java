package Phase1.UserActions;

import Phase1.States.State;
import javafx.scene.image.ImageView;

public class ProfileAction extends UserActions{

    private String bio;
    private String gender;
    private String preference;
    private String username;
    private String password;
    private State state;
    private ImageView image;

    public ProfileAction(int id){
        super(id);

    }
}
