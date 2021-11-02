package Phase1.Users;

import java.util.ArrayList;

public class MessageUser extends User {
    /**
     * Represents the User's information that pertains to Messaging other Users.
     *
     * @param threads is an ArrayList of all the messaging threads this user has, represented by integers
     * @param matches is an ArrayList of all the matches this user has, represented by integers
     */

    ArrayList<Integer> threads;
    ArrayList<Integer> matches;

    public MessageUser(int id, String fName, String lName, ArrayList<Integer> threads, ArrayList<Integer> matches) {
        super(id, fName, lName);
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
