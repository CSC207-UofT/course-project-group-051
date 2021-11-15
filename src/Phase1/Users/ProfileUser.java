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

    /**
     * Creates a profile user
     * @param id the user's ID
     * @param fName the user's first name
     * @param lName the user's last name
     * @param birthdate the user's birth day
     * @param username the user's username
     * @param password the user's password
     * @param image the user's image path
     */
    public ProfileUser(int id, String fName, String lName, Date birthdate, String username, String password,
                       String image) {
        super(id, fName, lName, birthdate, password);
        this.state = new LoggedOut();
        this.image = image;
        this.username = username;
    }
    /**
     * Sets the first name
     * @param s the first name
     */
    public void setfName(String s){
        this.fName = s;
    }

    /**Sets the last name
     * @param s the last name
     */
    public void setLName(String s){
        this.lName = s;
    }

    /**
     * @return the image path of the user
     */
    public String getImagePath(){
        return this.image;
    }
    /**
     * @return the bio of the user
     */
    public String getBio() {
        return this.bio;
    }

    /**
     * @return the gender of the user
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Sets the bio of the user
     * @param bio the user's bio
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * Sets the date of birth
     * @param dob the date of birth
     */
    public void setDOB(String dob){
        this.birthdate = dob;
    }

    /**
     * Sets the gender
     * @param gender the user's gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** sets the image path
     * @param path the intended image path
     * @return true if the image path is changed, false otherwise
     */
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

    /**
     * @return the person's image in imageview
     */
    public ImageView getImage(){
        try{
        return new ImageView(new Image(new FileInputStream(this.image)));}
        catch(Exception io){
            return new ImageView();
        }
    }

    /**
     * @return the person's gender preference
     */
    public String getPreference() {
        return this.preference;
    }

    /** Sets the gender preference
     * @param preference the person's gender preference
     */
    public void setPreference(String preference) {
        this.preference = preference;
    }

    /**
     * @return the person's username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the person's username
     * @param username the person's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the person's password
     * @param password the intended password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
