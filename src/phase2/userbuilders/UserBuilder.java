package phase2.userbuilders;

import phase2.dataaccess.DataAccessInterface2;
import phase2.dataaccess.DataBaseAccess2;
import phase2.users.PublicUser;

/**
 * Outlines the steps needed to build a User class using data from our database.
 */
public interface UserBuilder {
    PublicUser build(DataAccessInterface2 db, int id);

}
