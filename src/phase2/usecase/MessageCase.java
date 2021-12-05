package phase2.usecase;

import phase2.dataaccess.DataAccessInterface;

import java.util.ArrayList;

public class MessageCase {

    int primaryUser; // the primary user ID.
    int secondaryUser; // the secondary user ID
    DataAccessInterface db;
    int threadID;

    public MessageCase(int primary, int secondary, DataAccessInterface db){
        primaryUser = primary;
        secondaryUser = secondary;
        this.db = db;
        threadID = getThreadID();
        if(threadID == -1){
            threadID = createThread();
        }
    }

    private int getThreadID(){
        ArrayList<Integer> threads1 = db.getThreads(primaryUser);
        ArrayList<Integer> threads2 = db.getThreads(secondaryUser);
        for(int x: threads1){
            if(threads2.contains(x)){
                return x;
            }
        }
        return -1;
    }

    private int createThread(){
        return db.createThread(primaryUser, secondaryUser);
    }

    public void CreateMessage(String msg){
        db.createMessage(threadID, primaryUser, secondaryUser, msg);
    }
}
