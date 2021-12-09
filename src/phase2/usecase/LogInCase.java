package phase2.usecase;

import phase2.dataaccess.DataAccessInterface;

/**
 * Provides the actions for allowing a User to log in.
 */
public class LogInCase {

    private final DataAccessInterface db;

    /**
     * @param db A reference to our database.
     */
    public LogInCase(DataAccessInterface db){
        this.db = db;
    }

    /**
     * Tries to log in a user with the given username, and password, returns the result.
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The result of the login attempt. (user's ID if successful, -1 if failed)
     */
    public int loginUser(String username, String password){
        return db.logIn(username, password);
    }
}
