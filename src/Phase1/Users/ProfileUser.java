package Phase1.Users;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

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
    private String image;
    private int age;

    public ProfileUser(int id) {
        super(id);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge(){return this.age;}


    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return this.bio;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    //probably not necessary anymore since we take date in sign up and then save age in the database.
//    public int getAge() {
//        Date today = new Date();
//        long diff = today.getTime() - this.getBirthdate().getTime();
//        int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
//
//        return days / 365;}
    /**
     * A function to upload and set the image of a user
     *
     * @param path a string representation of the directory path of the image to be uploaded
     * @return boolean set to true if the image was successfully added, and false if not (never used, but allows
     * try/catch)
     */
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

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getPreference() {
        return this.preference;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() { return this.password; }
}
