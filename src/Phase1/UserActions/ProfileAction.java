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
    private void updateFirstName(String fName){
        this.user.setfName(fName); //take input from text field
         // add these into a save button?
    };

    private void updateLastName(String lName){
        db.setlName(this.user.getlName());
    };

    private void updateBirthday(String fName){
        db.setBirthday(this.user.getfName());
    };

    private void updatePreferences(String preference){
        // take input from text field
        // set this.user.setPreferences(preference);

    }

    private void updateGender(String gender){
        // take input from text field
        // set this.user.setGender(gender);
    }

    private void updateImage(Image image){

    }

    private void updatePassword(String password){

    }

    public void saveProfile(Map results){
        db.updateFirstName(results.get("fName"));
        db.setfName(this.user.getfName());
        db.update()
        updateFirstName();
        db.updateName(fname, lastname)
    //bunch of db calls to update attributes from our class
    }

    public void transition(){};
}
