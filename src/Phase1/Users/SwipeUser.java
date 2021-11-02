package Phase1.Users;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a User to be swiped on. Which is also all the data that the current User can view.
 */
public class SwipeUser extends User {

    int age;
    String gender;
    String bio;
    int swiper; //ID of the current User who is swiping.
    boolean gotliked;


    public SwipeUser(int id, String fName, String lName, Date birthdate, String password) {
        super(id, fName, lName, birthdate, password);
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
