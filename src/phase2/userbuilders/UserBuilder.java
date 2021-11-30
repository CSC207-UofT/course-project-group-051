package phase2.userbuilders;

import phase2.dataaccess.DataAccessInterface;
import phase2.users.User;

/**
 * Outlines the steps needed to build a User class using data from our database.
 */
public abstract class UserBuilder<T extends User> {

    public abstract void buildSpecificUser();

    public abstract T getResult();

    /**
     * Adds the data to a given User that all Users are required to have.
     * @param result The User to add the base data to.
     * @param db A reference to our database so we can read from it.
     */
    public static void buildBaseUser(User result, DataAccessInterface db) {

        int id = result.getId();

        String fName = db.getFirstName(id);
        String lName = db.getLastName(id);

        result.setfName(fName);
        result.setlName(lName);

    }

}
