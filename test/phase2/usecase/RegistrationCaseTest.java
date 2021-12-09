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

class RegistrationCaseTest {

    private DataAccessInterface db;
    private RegistrationCase registrationCase;
    private static SelfUser currentUser;

    @BeforeEach
    void setUp() {

        db = new DataBaseAccess();

        // map representation of VALID user entry
        Map<String, String> valid_inputs = new HashMap();
        valid_inputs.put(UserInfoConstants.AGE, "21");
        valid_inputs.put(UserInfoConstants.UT_ID, "123456789");
        valid_inputs.put(UserInfoConstants.PASSWORD, "password");
        valid_inputs.put(UserInfoConstants.PASSWORD_C, "password");
        valid_inputs.put(UserInfoConstants.FIRST_NAME, "john");
        valid_inputs.put(UserInfoConstants.LAST_NAME, "doe");
        valid_inputs.put(UserInfoConstants.GENDER, "Male");
        valid_inputs.put(UserInfoConstants.GENDER_PREFERENCE, "Female");

        // map representation of INVALID user entry
        Map<String, String> invalid_inputs = new HashMap();
        invalid_inputs.put(UserInfoConstants.AGE, "1e");
        invalid_inputs.put(UserInfoConstants.UT_ID, "user1");
        invalid_inputs.put(UserInfoConstants.PASSWORD, "password");
        invalid_inputs.put(UserInfoConstants.PASSWORD_C, "passwordERROR");
        invalid_inputs.put(UserInfoConstants.FIRST_NAME, "");
        invalid_inputs.put(UserInfoConstants.LAST_NAME, "");
        invalid_inputs.put(UserInfoConstants.GENDER, "Male");
        invalid_inputs.put(UserInfoConstants.GENDER_PREFERENCE, "Female");


    }

    @Test
    void createAccountSuccess() {
        // Creating account
        RegistrationCase rcase = new RegistrationCase(db);
        List<String> expectedErrors = new ArrayList<String>
        List<String> actualErrors = rcase.createAccount(valid_inputs);
        assertEquals(actualErrors, expectedErrors);

    }

    void createAccountFail() {
        RegistrationCase rcase = new RegistrationCase(db);
        List<String> expectedErrors = new ArrayList<String>;
        errors.add("Missing registration information.");
        errors.add("Passwords did not match.");
        errors.add("Please enter a numeric value for age.");
        errors.add("Account already exists.");

        List<String> actualErrors = rcase.createAccount(invalid_inputs);
        assertEquals(actualErrors, expectedErrors);

    }

    void getStringMap() {
        Map<String, String> javafx_text_inputs = new HashMap();
        javafx_text_inputs.put(UserInfoConstants.AGE, javafx.text.Text("21"));
        javafx_text_inputs.put(UserInfoConstants.UT_ID, javafx.text.Text("123456789"));
        javafx_text_inputs.put(UserInfoConstants.PASSWORD, javafx.text.Text("password"));
        javafx_text_inputs.put(UserInfoConstants.PASSWORD_C, javafx.text.Text("password"));
        javafx_text_inputs.put(UserInfoConstants.FIRST_NAME, javafx.text.Text("john"));
        javafx_text_inputs.put(UserInfoConstants.LAST_NAME, javafx.text.Text("doe"));
        javafx_text_inputs.put(UserInfoConstants.GENDER, javafx.text.Text("Male"));
        javafx_text_inputs.put(UserInfoConstants.GENDER_PREFERENCE, javafx.text.Text("Female"));

        actualResult = getStringMap(javafx_text_inputs);
        expectedResult = valid_inputs;

        assertEqual(expectedResult, actualResult);
    }
}