package demo2;


import java.util.ArrayList;
import java.util.List;

/**
 * Represents a thread with messages between 2 users
 */
public class Thread {

    //list of messages
    private List<Message> messages;
    //Users involved in these messages
    private User user1, user2;



    public Thread(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user1;
        messages = new ArrayList<>();
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public void addMessage(Message msg) {
        messages.add(msg);
    }

    /**
     * Returns a String representation of all the Messages in this Thread
     */
    public ArrayList<String> seeMessages(){

        ArrayList<String> allMessages = new ArrayList<>();

        for (Message m: messages){
            allMessages.add(m.toString());
        }
        return allMessages;

    }
}
