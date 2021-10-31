package Phase1.Users;

import java.util.ArrayList;

/**
 * Represents a User to be swiped on.
 */
public class SwipeUser extends User {

    int age;
    String gender;
    String bio;
    int swiper; //ID of the current User who is swiping.
    boolean gotliked;


    public SwipeUser(int id, String fName, String lName) {
        super(id, fName, lName);
        swiper = -1;
        gotliked = false;
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
