package phase2.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import phase2.dataaccess.DataAccessInterface;
import phase2.dataaccess.DataBaseAccess;

import static org.junit.jupiter.api.Assertions.*;

class SwipeCaseTest {

    DataAccessInterface db;

    @BeforeEach
    void setUp() {

        db = new DataBaseAccess();
        //db.setUp();
    }

    @Test
    void getImageTest() {
    }

    @Test
    void getData() {
    }

    @Test
    void likeCurrentUser() {
    }

    @Test
    void nextUser() {
    }
}