package Phase1.Users;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents the User's information that pertains to Messaging other Users.
 *
 * @param threads is an ArrayList of all the messaging threads this user has, represented by integers
 * @param matches is an ArrayList of all the matches this user has, represented by integers
 */
public class MessageUser extends User {


    private ArrayList<Integer> threads;
    private ArrayList<Integer> matches;

    public MessageUser(int id, String fName, String lName, ArrayList<Integer> threads, ArrayList<Integer> matches) {
        super(id, fName, lName, new Date(1999,11,7), "dummypasswor");
        this.threads = threads;
        this.matches = matches;
    }

    public ArrayList<Integer> getThreads() {
        return this.threads;
    }

    public ArrayList<Integer> getMatches() {
        return this.matches;
    }
}
