package phase2.usecase;

import phase2.dataaccess.DataAccessInterface;
import phase2.userbuilders.PublicUserBuilder;
import phase2.users.SelfUser;

import java.util.ArrayList;

/**
 * Provides the processes needed to send messages betweeen Users.
 */
public class MessageCase {

    SelfUser currentUser; // the primary user ID.
    int receiver; // the secondary user ID
    DataAccessInterface db;
    int threadID;

    /**
     * @param currentUser The currently logged-in User.
     * @param receiver The User who the message will be sent to.
     * @param db A reference to our database.
     */
    public MessageCase(DataAccessInterface db, SelfUser currentUser, int receiver){
        this.currentUser = currentUser;
        this.receiver = receiver;
        this.db = db;

        threadID = getThreadID();
        if(threadID == -1){
            threadID = createThread();
        }
    }


    /**
     * Sends a message to  the Receiver.
     * @param msg The message to be sent to the Receiver from the currentUser.
     */
    public void sendMessage(String msg){

        db.createMessage(threadID, currentUser.getId(), receiver, msg);
    }


    /**
     * Determines if there is a thread between the currentUser and Receiver, and returns it if there is.
     * @return The threadID of a Thread between the currentUser and the Receiver or -1 if there isn't one.
     */
    private int getThreadID(){
        ArrayList<Integer> senderThreads = db.getThreads(currentUser.getId());
        ArrayList<Integer> receiverThreads = db.getThreads(receiver);
        for(int id: senderThreads){
            if(receiverThreads.contains(id)){
                return id;
            }
        }
        return -1;
    }

    /**
     * Calls the Database to create a new thread between the currentUser and Receiver.
     * @return The Id of the newly created thread.
     */
    private int createThread(){
        return db.createThread(currentUser.getId(), receiver);
    }

    /**
     * @return returns the name of the receiver of the messages.
     */
    public String getReceiverName() {

        return PublicUserBuilder.build(db, receiver).getFirstName();

    }


    public ArrayList<String[]> getFullThread(){
        System.out.println(db.getThread(threadID));
        return db.getThread(threadID);
    }


}
