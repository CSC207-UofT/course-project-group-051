package demo2;

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
}
