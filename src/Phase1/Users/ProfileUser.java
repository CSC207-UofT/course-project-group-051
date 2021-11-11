package Phase1.Users;

import Phase1.States.LoggedOut;
import Phase1.States.State;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Represents the User's information that pertains to editing/viewing profile information.
 *
 * @param bio is the bio inputted by the user
 * @param gender is the gender of the user
 * @param age is the age of the user
 * @param preference is the gender preference of the user
 * @param username is the username of the user
 * @param password is the password of the user to access their profile
 */
public class ProfileUser extends User {

    private String bio;
    private String gender;
    private String preference;
    private String username;
    private String password;
    private State state;
    private String image;

    public ProfileUser(int id, String fName, String lName, Date birthdate, String password, String image) {
        super(id, fName, lName, birthdate, password);
        this.state = new LoggedOut();
        this.image = image;

    }
    public String getImagePath(){
        return this.image;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        Date today = new Date();
        long diff = today.getTime() - this.getBirthdate().getTime();
        int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        return days / 365;
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
