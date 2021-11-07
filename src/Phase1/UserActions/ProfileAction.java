package Phase1.UserActions;

import Phase1.Users.ProfileUser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class ProfileAction implements Transitionable{

    private ProfileUser user;

    public ProfileAction(int id, String fName, String lName, Date birthdate, String password, ImageView image){
        this.user = new ProfileUser(id, db.getFirstName(id), db.getLastName(id),
                db.getBirthday(), db.getPassword(), db.getImage());

    }
    private void updateImage(Image image){
        //seperate button that updates the profile picture?
    }


    private void updateProfile(Map<String, String> results){
        // TODO: ADD CHECKS FOR THE FIELDS - HERE OR DB?
        this.user.setfName(results.get("fName"));
        this.user.setLName(results.get("lName"));
        this.user.setBio(results.get("bio"));
        this.user.setGender(results.get("gender"));
        this.user.setPreference(results.get("preferences"));
        this.user.setBirthday(results.get("birthday"));
        this.user.setPassword(results.get("password"));

        db.setFirstName(this.user.getfName());
        db.setLastName(this.user.getlName());
        db.setBio(this.user.getBio());
        db.setGender(this.user.getGender())
        db.setGenderPreference(this.user.getPreference());
        db.setBirthday(this.user.getBirthdate());
        db.setPassword(this.user.getPassword());

    }

    public void transition(){};
}
