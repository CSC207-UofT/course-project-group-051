package Phase1.Users;

import java.util.ArrayList;

/**
 * Represents the User's information that pertains to Messaging other Users.
 */
public class MessageUser extends User {

    ArrayList<Integer> threads;
    ArrayList<Integer> matches;

    public MessageUser(int id, String fName, String lName, ArrayList<Integer> threads, ArrayList<Integer> matches) {
        super(id, fName, lName);
        this.threads = threads;
        this.matches = matches;
    }

    public ArrayList<Integer> getThreads() {
        return threads;
    }

    public ArrayList<Integer> getMatches() {
        return matches;
    }
}
