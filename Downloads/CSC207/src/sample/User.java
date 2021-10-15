package sample;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

public class User {
    public String firstName;
    public String lastName;
    public Date DOB;
    public String Occupation;
    public BufferedImage profilePic;
    public List<String> hobbies;
    public String bio;
    public String gender;
    public String orientation;
    private String password;
    private String username;
    public User(String firstName, String lastName, Date DOB, String Occupation, BufferedImage profilePic,
                List<String> hobbies, String bio, String gender, String orientation, String username){

        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.Occupation = Occupation;
        this.profilePic = profilePic;
        this.hobbies = hobbies;
        this.bio = bio;
        this.gender = gender;
        this.orientation = orientation;
        this.username = username;
    }
    public boolean resetPassword(String oldPW, String newPW){
        if(oldPW == this.password){
            this.password = newPW;
            return true;
        }
        else{
            System.out.println("Wrong password, please try again.");
            return false;
        }
    }


}
