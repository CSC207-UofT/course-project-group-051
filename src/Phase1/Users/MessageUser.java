package Phase1.Users;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents the User's information that pertains to Messaging other Users.
 */
public class MessageUser extends User {


    private ArrayList<Integer> threads;
    private ArrayList<Integer> matches;

    /**
     * Creates a message user object
     * @param id the user's ID
     * @param fName the user's first name
     * @param lName the user's last name
     * @param threads the user's threads
     * @param matches the user's matches
     * @param dob the user's birthday
     * @param password the user's password
     */

    public MessageUser(int id, String fName, String lName, String dob, String password, ArrayList<Integer> threads,
                       ArrayList<Integer> matches) {
        super(id, fName, lName, new Date(dob), password);
        this.threads = threads;
        this.matches = matches;
    }

    /**
     * @return the list of threads
     */
    public ArrayList<Integer> getThreads() {
        return this.threads;
    }

    /**
     * @return the matches of the current user
     */
    public ArrayList<Integer> getMatches() {
        return this.matches;
    }
}
