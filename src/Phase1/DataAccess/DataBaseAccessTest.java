package Phase1.DataAccess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataBaseAccessTest {
    DataBaseAccess db;

    @BeforeEach
    void setUpDB() {
        db = new DataBaseAccess();
        db.resetDB();
        db.setUpDB();
    }

    @Test
    void logInFailure() {

        int actual = db.logIn("wrongUsername", "password");
        int expected = -1;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void testGetters() {
    }

    @Test
    void testgetThreads() {
    }

    @Test
    void testSetters() {
    }

    @Test
    void likeUser() {
    }

    @Test
    void unlikeUser() {
    }

    @Test
    void admireUser() {
    }

    @Test
    void stopAdmiringUser() {
    }

    @Test
    void checkConversation() {
    }

    @Test
    void createThread() {
    }

    @Test
    void createMessage() {
    }

    @Test
    void getSwipeList() {
    }

    @Test
    void getThreadMsg() {
    }

    @Test
    void createUser() {
    }
}