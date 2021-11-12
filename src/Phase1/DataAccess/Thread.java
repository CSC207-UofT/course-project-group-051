package Phase1.DataAccess;

import java.util.ArrayList;

public class Thread {

    /**
     * Constructs an instance of Thread
     * Defines a new thread of messages between 2 users who have matched
     *
     * @param Messages is a new empty ArrayList storing the messages sent
     * @param firstUser is the user initializing the messages
     * @param secondUser is the user receiving the messages
     */

    ArrayList<String[]> Messages;
    int firstUser;
    int secondUser;
    int id;

    public Thread(int idOne, int idTwo){
        this.Messages = new ArrayList<>();
        this.firstUser = idOne;
        this.secondUser = idTwo;
    }

    public int getFirstUser(){
        return this.firstUser;
    }

    public int getSecondUser(){
        return this.secondUser;
    }


}
