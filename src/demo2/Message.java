package demo2;

public class Message {
    private User sender;
    private User receiver;
    private String msg;
    public Message(User sender, User receiver, String msg){
        this.sender = sender;
        this.receiver = receiver;
        this.msg = msg;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getMsg() {
        return msg;
    }
}
