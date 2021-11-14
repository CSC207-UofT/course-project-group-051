package Phase1.UserActions;
import Phase1.DataAccess.DataAccessInterface;
import Phase1.UserBuilders.BuildMessageUser;
import Phase1.Users.MessageUser;
import javafx.scene.image.Image;
import Phase1.DataAccess.DataBaseAccess;
import java.util.ArrayList;

/**
 * This class creates a new thread of messages between 2 users. Using MessageUser and BuildMessageUser, a new thread
 * and the necessary functionality for two users to message one another.
 */

public class MessageAction implements Transitionable {
    private MessageUser sender;
    private String newMessage;
    private int receiverID;
    private BuildMessageUser builder;

    /**
     * Constructs a MessageAction instance, initializing ID's, messages, and database access variables
     * @param senderID an integer value describing the unique ID of the user sending the message
     * @param receiverID an integer value describing the unique ID of the user receiving the message
     * @param newMessage a string of the message to be sent by the sender
     */

    public MessageAction(int senderID, int receiverID, String newMessage) {
        DataAccessInterface db = new DataBaseAccess();
        this.builder = new BuildMessageUser(senderID, db);
        this.sender = builder.buildUser();
        this.newMessage = newMessage;
        this.receiverID = receiverID;
    }

    public int getReceiverID(){
        return this.receiverID;
    }

    public BuildMessageUser getBuilder() {
        return this.builder;
    }

    public String getNewMessage() {
        return this.newMessage;
    }

    /**
     * Determines if a new thread is needing to be created, or if a message needs to be added to an existing thread.
     */

    public void conversationAction(){
        int threadID = this.getBuilder().getDB().checkConversation(sender.getId(), this.getReceiverID());
        if (threadID == -1) {
            int newThread = this.getBuilder().getDB().createThread(this.sender.getId(), this.getReceiverID());
            this.getBuilder().getDB().createMessage(newThread, this.sender.getId(), this.getReceiverID(),
                    this.newMessage);
            return;
        }
        this.getBuilder().getDB().createMessage(threadID, this.sender.getId(), this.getReceiverID(),
                this.getNewMessage());
    }

    public void transition(){
    }

}
