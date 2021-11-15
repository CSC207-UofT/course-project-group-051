package Phase1.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Represents a User to be swiped on. Which is also all the data that the current User can view.
 */

public class SwipeUser extends User {


    private int age;
    private String gender;
    private String bio;
    private int swiper; //ID of the current User who is swiping.
    private boolean gotliked;
    private String imgPath;

    /**
     * Creates a swipe user object
     * @param id the user's ID
     * @param fName the user's first name
     * @param lName the user's last name
     * @param birthdate the user's birthday
     * @param password the user's password
     * @param imgPath the user's image path
     */
    public SwipeUser(int id, String fName, String lName, Date birthdate, String password, String imgPath) {
        super(id, fName, lName, birthdate, password);
        this.swiper = -1;
        this.gotliked = false;
        this.imgPath = imgPath;
    }

    /**
     * Sets the bio
     * @param bio the user's bio in String
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * @return the bio
     */
    public String getBio() {
        return this.bio;

    }



}
