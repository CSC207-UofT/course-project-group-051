package Phase1.Test.BuilderTests;

import Phase1.DataAccess.DataAccessInterface;
import Phase1.DataAccess.DataBaseAccess;
import Phase1.UserBuilders.BuildMessageUser;
import Phase1.Users.MessageUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BuildMessageUserTest {

    MessageUser result;
    DataAccessInterface db = new DataBaseAccess();
    BuildMessageUser builder;

    @BeforeAll
    static void setUpData() {
        DataAccessInterface db = new DataBaseAccess();
        BuildMessageUser builder = new BuildMessageUser(1, db);
    }

    @BeforeEach
    void setUpUser() {
        result = builder.buildUser();
    }

    @Test
    void testMessageUserAttributes() {

        ArrayList<Integer> threads = result.getThreads();
        ArrayList<Integer> matches = result.getMatches();

        Assertions.assertEquals(db.getThreads(result.getId()), threads);


    }

    @Test
    void testUserAttributes() {

        int id = result.getId();

        Assertions.assertEquals(1, id);

        String fname = result.getfName();
        String lname = result.getlName();


        Assertions.assertEquals(db.getFirstName(result.getId()), fname);
        Assertions.assertEquals(db.getLastName(result.getId()), lname);


    }
}