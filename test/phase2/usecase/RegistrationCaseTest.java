package phase2.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import phase2.constants.UserInfoConstants;
import phase2.dataaccess.DataBaseAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationCaseTest {

    private final DataBaseAccess db = new DataBaseAccess();
    private final RegistrationCase registrationCase= new RegistrationCase(db);
    private Map<String, String> valid_inputs;
    private Map<String, String> invalid_inputs;

    @BeforeEach
    void setUp() {
        db.resetDB();
        db.setUpDB();
        // map representation of VALID user entry
        valid_inputs = new HashMap<>();
        valid_inputs.put(UserInfoConstants.AGE, "21");
        valid_inputs.put(UserInfoConstants.UT_ID, "123456789");
        valid_inputs.put(UserInfoConstants.PASSWORD, "password");
        valid_inputs.put(UserInfoConstants.PASSWORD_C, "password");
        valid_inputs.put(UserInfoConstants.FIRST_NAME, "john");
        valid_inputs.put(UserInfoConstants.LAST_NAME, "doe");
        valid_inputs.put(UserInfoConstants.GENDER, "Male");
        valid_inputs.put(UserInfoConstants.GENDER_PREFERENCE, "Female");

        // map representation of INVALID user entry
        invalid_inputs = new HashMap<>();
        invalid_inputs.put(UserInfoConstants.AGE, "f");
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
        List<String> expectedErrors = new ArrayList<>();
        List<String> actualErrors = registrationCase.createAccount(valid_inputs);
        assertEquals(expectedErrors, actualErrors);

    }

    @Test
    void createAccountFail() {
        List<String> expectedErrors = new ArrayList<>();
        expectedErrors.add("Missing registration information.");
        expectedErrors.add("Please enter a numeric value for age.");
        expectedErrors.add("Passwords did not match.");
        expectedErrors.add("Account already exists.");

        List<String> actualErrors = registrationCase.createAccount(invalid_inputs);
        assertEquals(expectedErrors, actualErrors);

    }
}