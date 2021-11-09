package Phase1.Users;

import java.util.ArrayList;

/**
 * Represents the User's information that pertains to Messaging other Users.
 */
public class MessageUser extends User {


    private ArrayList<Integer> threads;
    private ArrayList<Integer> matches;

    public MessageUser(int id) {
        super(id);
    }

    public ArrayList<Integer> getThreads() {
        return this.threads;
    }

    public ArrayList<Integer> getMatches() {
        return this.matches;
    }

    public void setThreads(ArrayList<Integer> threads) { this.threads = threads; }

    public void setMatches(ArrayList<Integer> matches) { this.matches = matches; }
}
