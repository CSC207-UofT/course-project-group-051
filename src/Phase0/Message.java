package Phase0;

/**
 * Represents a single message with a sender, receiver, and content.
 */
public class Message {
    private User sender;
    private User receiver;
    private String content;


    public Message(User sender, User receiver, String content){
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    /** Returns the string representation of this message
     *The format of string is sender + ": /n" + content
     */
    @Override
    public String toString() {
        return String.format(sender + ": \n" + content);
    }
}
