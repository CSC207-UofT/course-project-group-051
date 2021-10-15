package sample;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Message {
    private User sender;
    private User receiver;
    private String content;
    private LocalDateTime time;
    public Message(User sender, User receiver, String content, LocalDateTime time){
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.time = time;
    }
}
