package Phase1.Users;

import java.util.ArrayList;


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
    private int swiper;
    private boolean gotLiked;


    public SwipeUser(int id, String fName, String lName) {
        super(id, fName, lName);
        this.swiper = -1;
        this.gotLiked = false;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String getBio() {
        return this.bio;
    }
}
