package Phase1.Users;

import Phase1.States.State;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Represents the User's information that pertains to editing/viewing profile information.
 */
public class ProfileUser extends User {

    // TODO finalize these variables.
    private String bio;
    private String gender;
    private String preference;
    private String username;
    private String password;
    private State state;
    private String image;
    private String birthdate;

    public ProfileUser(int id) {
        super(id);
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

    public int getAge() { // do this in builder if its needed.
        Date today = new Date();
        long diff = today.getTime() - this.getBirthdate().getTime();
        int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        return days / 365;}

    public boolean setImage(String path){
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
