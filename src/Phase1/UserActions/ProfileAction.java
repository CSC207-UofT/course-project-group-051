package Phase1.UserActions;

import Phase1.Users.ProfileUser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class ProfileAction implements Transitionable{

    private ProfileUser user;

    public ProfileAction(int id, String fName, String lName, Date birthdate, String password, ImageView image){
        this.user = new ProfileUser(id, db.getFirstName(id), db.getLastName(id),
                db.getBirthday(), db.getPassword(), db.getImage());

    }
    public void updateFirstName(String fName){
        this.user.setFirstName(); //take input from text field
        db.setfName(this.user.getfName()); // add these into a save button?
    };

    public void updateLastName(String lName){
        db.setlName(this.user.getlName());
    };

    public void updateBirthday(String fName){
        db.setBirthday(this.user.getfName());
    };

    public void updatePreferences(ArrayList<String> preferences){
        // take input from text field
        // set this.user.setPreferences(preferences);

    }

    public void updateGender(String gender){
        // take input from text field
        // set this.user.setGender(gender);
    }

    public void updateImage(Image image){

    }

    public void updatePassword(){

    }

    public void saveProfile(){
        //bunch of db calls to update attributes from our class
    }

    public void transition(){};
}
