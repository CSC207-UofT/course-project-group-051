package Phase1.Users;

import java.io.FileInputStream;


/**
 * Represents a User to be swiped on. Which is also all the data that the current User can view.
 */

public class SwipeUser extends User {


    private String gender;
    private String bio;
    private String imagePath;
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

    public boolean setImagePath(String path){
        try{
            FileInputStream f = new FileInputStream(path);
            this.imagePath = path;
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public String getImagePath() {
        return imagePath;
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

    public String getAge() {
        return Integer.toString(age);
    }


}
