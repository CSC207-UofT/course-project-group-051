package Phase1.Users;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;


/**
 * Represents a User to be swiped on. Which is also all the data that the current User can view.
 */

public class SwipeUser extends User {


    private String gender;
    private String bio;
    private String image;
    private int age;


    public SwipeUser(int id) {

        super(id);
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;

    }

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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
