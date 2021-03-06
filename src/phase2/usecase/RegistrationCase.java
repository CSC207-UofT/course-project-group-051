package phase2.usecase;

import phase2.constants.Errors;
import phase2.constants.UserInfoConstants;
import phase2.dataaccess.DataAccessInterface;

import java.util.ArrayList;
import java.util.Map;


/**
 * Provides the actions necessary for when a new User is registering/creating an account.
 */
public class RegistrationCase {

    private final DataAccessInterface db;

    /**
     * @param db A reference to our Database.
     */
    public RegistrationCase(DataAccessInterface db){
        this.db = db;
    }

    /**
     * Attempts to create an account with the values in data, returns a list of errors if there are any.
     * @param info A Map containing all the User's inputs for their registration. (name, age, bio, etc.)
     * @return A list of errors that came from this attempt at creating an account (returns an empty list if there
     * are none).
     */
    public ArrayList<String> createAccount(Map<String, String> info){
        ArrayList<String> errors = new ArrayList<>();
        if (info.containsValue("")){
            errors.add(Errors.MISSING);
        }
        if (!info.get(UserInfoConstants.AGE).equals("")) {
            try {
                Integer.parseInt(info.get(UserInfoConstants.AGE));
            } catch (NumberFormatException io) {
                errors.add(Errors.AGE);
            }
        }
        if(!info.get(UserInfoConstants.PASSWORD).equals(info.get(UserInfoConstants.PASSWORD_C))){
            errors.add(Errors.PASSWORD_MATCH);
        }
        if (db.logIn(info.get(UserInfoConstants.UT_ID), info.get(UserInfoConstants.PASSWORD)) != -1){
            errors.add(Errors.EXISTS);
        }

        if(errors.isEmpty()) {
            db.createUser(info);
            return errors;

        }
        return errors;
    }
}
