package phase2.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import phase2.dataaccess.DataAccessInterface;
import phase2.dataaccess.DataBaseAccess;
import phase2.usecase.SwipeCase;
import phase2.userbuilders.PublicUserBuilder;
import phase2.userbuilders.SelfUserBuilder;
import phase2.users.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SwipeCaseTest {

    private DataBaseAccess db = new DataBaseAccess();
    private SwipeCase swipeCase;
    private static SelfUser currentUser;
    private static PublicUser publicUser;

    @BeforeEach
    void setUp() {

        db = new DataBaseAccess();
        db.setUpDB();

        currentUser = SelfUserBuilder.build(db, 1);
        publicUser = PublicUserBuilder.build(db, 2);

        Queue<PublicUser> queue = new LinkedList<>();
        queue.add(publicUser);

        swipeCase = new SwipeCase(db, currentUser, queue);
    }

    @Test
    void getImageTest() {

        String expected = currentUser.getImagePath();
        String actual = swipeCase.getImage();

        assertEquals(expected, actual);

    }

    @Test
    void isEmptyTrueTest() {

        //likes the otherUser and switches to the next user which there are none.
        swipeCase.likeCurrentUser();

        boolean actual = swipeCase.isEmpty();

        assertTrue(actual);

    }

    @Test
    void isEmptyFalseTest() {

        boolean actual = swipeCase.isEmpty();

        assertFalse(actual);

    }

    @Test
    void likeCurrentUserTest() {

        swipeCase.likeCurrentUser();

        //get all the people who the currentUser liked.
        List<Integer> dbLikes = db.getLikes(currentUser.getId());

        //get all the people who have liked the otherUser.
        List<Integer> dbAdmirers = db.getAdmires(publicUser.getId());

        assertTrue(dbLikes.contains(2), "currentUser did not like the otherUser.");
        assertTrue(dbAdmirers.contains(1), "otherUser did not get admired by the currentUser.");

    }

    @Test
    void getDataTest() {

        Map<String, String> userData = swipeCase.getData();

        Set<String> actualKeys = userData.keySet();
        Set<String> actualValues = new HashSet<>(userData.values());

        Set<String> expectedKeys = new HashSet<>(Arrays.asList("Age", "Bio", "fName", "lName"));
        Set<String> expectedValues = new HashSet<>(Arrays.asList("1", "hi", "person2F", "person2L"));

        assertEquals(expectedKeys, actualKeys, "Keys are wrong");
        assertEquals(expectedValues, actualValues, "Values are wrong");


    }
}