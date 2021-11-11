package Phase1.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Represents a User to be swiped on. Which is also all the data that the current User can view.
 *
 * @param age is the age of the user being swiped on
 * @param gender is the gender of the user being swiped on
 * @param bio is the bio of the user being swiped on
 * @param swiper is the ID of the current user who is swiping
 * @param gotLiked is True if the swiper swipes right, and false if swiper swipes left
 */

public class SwipeUser extends User {


    private int age;
    private String gender;
    private String bio;
    private int swiper; //ID of the current User who is swiping.
    private boolean gotliked;
    private String imgPath;


    public SwipeUser(int id, String fName, String lName, Date birthdate, String password, String imgPath) {
        super(id, fName, lName, birthdate, password);
        this.swiper = -1;
        this.gotliked = false;
        this.imgPath = imgPath;
    }


    public void setBio(String bio) {
        this.bio = bio;
    }




    public String getBio() {
        return this.bio;

    }
}
