package phase2.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import phase2.dataaccess.DataAccessInterface;
import phase2.dataaccess.DataBaseAccess;
import phase2.userbuilders.PublicUserBuilder;
import phase2.userbuilders.SelfUserBuilder;
import phase2.users.PublicUser;
import phase2.users.SelfUser;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class MessageCaseTest {

    private DataAccessInterface db;
    private MessageCase messageCase;
    private static SelfUser currentUser;

    @BeforeEach
    void setUp() {

        db = new DataBaseAccess();
        //db.setUp();

        currentUser = SelfUserBuilder.build(db, 1);

        messageCase = new MessageCase(db, currentUser, 2);
    }

    @Test
    void sendMessage() {

        //Create a message between the 2 users so that we can track it.
        int threadID = db.createThread(1, 2);
        messageCase.sendMessage("hello");

        String actualMsg = db.getThread(threadID).get(0)[0];
        String expectedMsg = "hello";

        assertEquals(expectedMsg, actualMsg);

    }

    @Test
    void getReceiverName() {
    }

    @Test
    void getFullThread() {
    }
}