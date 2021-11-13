package Phase1.Test.ActionTests;

import Phase1.DataAccess.DataAccessInterface;
import Phase1.DataAccess.DataBaseAccess;
import Phase1.UserActions.RegistrationResults;
import Phase1.UserActions.Registrator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class RegistratorTest {
    DataAccessInterface db;
    Registrator registrator;
    Map<String, String> input;

    @BeforeEach
    public void initialize() {
        db = new DataBaseAccess();
        // create db??
        registrator = new Registrator(db);
        input = new HashMap<>();
    }


    @Test
    void testCreateUserEmpty() throws Exception {

        input.put("DOB", "");
        input.put("fName", "d");
        input.put("lName", "a");
        input.put("username", "d");
        input.put("pw1", "d");
        input.put("pw2", "d");
        input.put("gender", "d");
        input.put("preference", "a");
        input.put("imagePath", "c");
        input.put("bio", "s");

        String actual = registrator.createUser(input);

        String expected = RegistrationResults.MISSING;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void testCreateUserNoMatch() throws Exception {

        input.put("DOB", "a");
        input.put("fName", "A");
        input.put("lName", "b");
        input.put("username", "c");
        input.put("pw1", "d");
        input.put("pw2", "s");
        input.put("gender", "a");
        input.put("preference", "a");
        input.put("imagePath", "c");
        input.put("bio", "s");

        String actual = registrator.createUser(input);

        String expected = RegistrationResults.PASSWORDMATCH;

        Assertions.assertEquals(expected, actual);

    }

    // TODO find out the username/password of the existing user.
//    @Test
//    void testCreateUserExists() throws Exception {
//
//        input.put("DOB", "");
//        input.put("fName", "A");
//        input.put("lName", "b");
//        input.put("username", "c");
//        input.put("pw1", "d");
//        input.put("pw2", "s");
//        input.put("gender", "a");
//        input.put("preference", "a");
//        input.put("imagePath", "c");
//        input.put("bio", "s");
//
//        String actual = registrator.createUser(input);
//
//        String expected = RegistrationResults.MISSING;
//
//        Assertions.assertEquals(expected, actual);
//
//    }

    @Test
    void testCreateUserSuccess() throws Exception {

        input.put("DOB", "A");
        input.put("fName", "A");
        input.put("lName", "b");
        input.put("username", "c");
        input.put("pw1", "d");
        input.put("pw2", "d");
        input.put("gender", "a");
        input.put("preference", "a");
        input.put("imagePath", "c");
        input.put("bio", "s");

        String actual = registrator.createUser(input);

        String expected = "1";

        Assertions.assertEquals(expected, actual);

    }
}