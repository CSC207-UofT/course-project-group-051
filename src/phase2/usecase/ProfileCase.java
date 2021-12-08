package phase2.usecase;

import phase2.controllers.ControllerFactory;
import phase2.dataaccess.DataAccessInterface;
import phase2.userbuilders.SelfUserBuilder;
import phase2.users.SelfUser;

import java.util.Map;

/**
 * Provides the actions necessary for a when we are updating a User's profile.
 */
public class ProfileCase {

    private final DataAccessInterface db;

    /**
     * @param db A reference to our database.
     */
    public ProfileCase(DataAccessInterface db){
        this.db = db;
    }

    /**
     * @param id The id of the user to update.
     * @param info All the new info to be saved in the database for this user.
     */
    public void updateUser(int id, Map<String, String> info){
        db.updateUserInfo(id, info);
        SelfUser user = SelfUserBuilder.build(db, id);
        ControllerFactory.getInstance().setCurrentUser(user);
    }


}
