package demo2;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        this.user2 = user2;
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
     * Returns a String representation of all the Messages in this Thread in a list.
     */
    public ArrayList<String> seeMessages(){

        ArrayList<String> allMessages = new ArrayList<>();

        for (Message m: messages){
            allMessages.add(m.toString());
        }
        return allMessages;

    }

    /**
     * Returns the User in this Thread that was NOT given.
     */
    public User getOtherUser(User user) {
        if (user == user1) {
            return user2;
        } else {
            return user1;
        }
    }


    /**
     * Returns a string representation of this thread.
     * @param user this User is viewing the thread so there is no reason to display his name in the String.
     */
    public String toString(User user) {
        String otherUser =  this.getOtherUser(user).toString();
        //String recentMessage = messages.get(messages.size()).toString(); Use this line to display a recent message.
        return otherUser + ": \n"; //OtherUser needs some title font
    }
}
