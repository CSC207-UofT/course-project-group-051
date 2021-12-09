package phase2.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import phase2.dataaccess.DataBaseAccess;
import phase2.userbuilders.PublicUserBuilder;
import phase2.userbuilders.SelfUserBuilder;
import phase2.users.PublicUser;
import phase2.users.SelfUser;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MessageCaseTest {

    private DataBaseAccess db = new DataBaseAccess();
    private MessageCase messageCase;
    private static SelfUser currentUser;
    private static PublicUser receiver;

    @BeforeEach
    void setUp() {

        db.resetDB();
        db.setUpDB();

        currentUser = SelfUserBuilder.build(db, 1);
        receiver = PublicUserBuilder.build(db, 2);

        messageCase = new MessageCase(db, currentUser, 2);
    }

    @Test
    void sendMessageTest() {

        //Create a message between the 2 users so that we can track it.
        int threadID = getThreadID();
        messageCase.sendMessage("hello");

        //Get the message that was sent and compare it to what should have been sent.
        String actualMsg = db.getThread(threadID).get(0)[0];
        String expectedMsg = "hello";
        assertEquals(expectedMsg, actualMsg);

        //Check that the sender and receivers are correct
        String actualSender = db.getThread(threadID).get(0)[1];
        String expectedSender = "1";
        assertEquals(expectedSender, actualSender);
        String actualReceiver = db.getThread(threadID).get(0)[2];
        String expectedReceiver = "2";
        assertEquals(actualReceiver, expectedReceiver);

    }

    @Test
    void getReceiverNameTest() {

        String expectedName = receiver.getFirstName();
        String actualName = messageCase.getReceiverName();

        assertEquals(expectedName, actualName);

    }

    @Test
    void getFullThreadTest() {


        //Create a message between the 2 users so that we can track it.
        int threadID = getThreadID();
        messageCase.sendMessage("hello");

        String[] actualMessage = db.getThread(threadID).get(0);
        String[] expectedMessage = {"hello", Integer.toString(currentUser.getId()), Integer.toString(receiver.getId())};

        assertArrayEquals(expectedMessage, actualMessage);

    }

    /**
     * Determines if there is a thread between the currentUser and Receiver, and returns it if there is.
     * @return The threadID of a Thread between the currentUser and the Receiver or -1 if there isn't one.
     */
    private int getThreadID(){
        ArrayList<Integer> senderThreads = db.getThreads(currentUser.getId());
        ArrayList<Integer> receiverThreads = db.getThreads(receiver.getId());
        for(int id: senderThreads){
            if(receiverThreads.contains(id)){
                return id;
            }
        }
        return -1;
    }
}