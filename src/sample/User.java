package sample;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    public String firstName;
    public String lastName;
    public Date DOB;
    public String Occupation;
    public BufferedImage profilePic;
    public ArrayList<String> hobbies;
    public String bio;
    public String gender;
    public String orientation;
    private String password;
    private String username;
    private ArrayList<User> admirers;
    private ArrayList<User> likes;
    public User(String firstName, String lastName, Date DOB, String Occupation, BufferedImage profilePic,
                ArrayList<String> hobbies, String bio, String gender, String orientation, String username, String pw){

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
        this.password = pw;
        this.admirers = new ArrayList<>();
        this.likes = new ArrayList<>();
    }

    /** Returns true if the oldPW matches the old password on file, false otherwise.
     * @param oldPW the old password
     * @param newPW the new password
     * @return true if the oldPW matches the old password on file, false otherwise.
     */
    public boolean resetPassword(String oldPW, String newPW){
        if(oldPW.equals(this.password)){
            this.password = newPW;
            return true;
        }
        else{
            System.out.println("Wrong password, please try again.");
            return false;
        }
    }

    /**
     * @param profile another user.
     * @return true if the profile is added to the liked list, false otherwise.
     */
    public boolean like(User profile){
        if(!this.likes.contains(profile)){
            this.likes.add(profile);
             profile.addAdmirer(this);
    return true;} else{
                    return false;}}


     /**
     * @return a list of matches.
     */
    public ArrayList<User> matches(){
         ArrayList m= new ArrayList<User>();
         for (User i: this.admirers){
            if(this.likes.contains(i)){m.add(i);}}
            return m;}

    /** Adds a user to the admirer list.
      * @param profile another user
     */
    public void addAdmirer(User profile){
        if(!this.admirers.contains(profile)){
            this.admirers.add(profile);
            }
}}