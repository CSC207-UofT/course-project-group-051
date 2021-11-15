package Phase1.Users;

import Phase1.States.LoggedOut;
import Phase1.States.State;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.util.Date;

/**
 * Represents the User's information that pertains to editing/viewing profile information.
 */
public class ProfileUser extends User {

    String bio;
    String gender;
    String preference;
    String username;
    String password;
    State state;
    String image;
    String birthdate;

    public ProfileUser(int id, String fName, String lName, Date birthdate, String username, String password, String image) {
        super(id, fName, lName, birthdate, password);
        this.state = new LoggedOut();
        this.image = image;
        this.username = username;
    }

    public void setfName(String s){
        this.fName = s;
    }
    public void setLName(String s){
        this.lName = s;
    }

    public String getImagePath(){
        return this.image;
    }

    public String getBio() {
        return this.bio;
    }


    public String getGender() {
        return this.gender;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setDOB(String dob){
        this.birthdate = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean setImagePath(String path){
        try{
            FileInputStream f = new FileInputStream(path);
        this.image = path;
        return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public ImageView getImage(){
        try{
        return new ImageView(new Image(new FileInputStream(this.image)));}
        catch(Exception io){
            return new ImageView();
        }
    }


    public String getPreference() {
        return this.preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
