package phase2.usecase;

import phase2.dataaccess.DataAccessInterface;

/** A use case to log in the user to the application
 */
public class LogInCase {

    DataAccessInterface db;

    /** Creates an instance of LogInCase
     *
     * @param db, the data access interface
     */
    public LogInCase(DataAccessInterface db){
        this.db = db;
    }

    /** Attempts to log the user into the application
     *
     * @param username, submitted username from LogInView
     * @param password, submitted password from LogInView
     * @return int, an Integer representation of a Boolean value, -1 is False
     */
    public int loginUser(String username, String password){
        return db.logIn(username, password);
    }
}
