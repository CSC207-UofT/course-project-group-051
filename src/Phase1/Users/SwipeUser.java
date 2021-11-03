package Phase1.Users;

import java.util.ArrayList;
import java.util.Date;

public class SwipeUser extends User {
    /**
     * Represents a User to be swiped on. Which is also all the data that the current User can view.
     *
     * @param age is the age of the user being swiped on
     * @param gender is the gender of the user being swiped on
     * @param bio is the bio of the user being swiped on
     * @param swiper is the ID of the current user who is swiping
     * @param gotLiked is True if the swiper swipes right, and false if swiper swipes left
     */

    private int age;
    private String gender;
    private String bio;
    private int swiper; //ID of the current User who is swiping.
    private boolean gotliked;


    public SwipeUser(int id, String fName, String lName, Date birthdate, String password) {
        super(id, fName, lName, birthdate, password);
        this.swiper = -1;
        this.gotliked = false;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getBio() {
        return bio;
    }
}
