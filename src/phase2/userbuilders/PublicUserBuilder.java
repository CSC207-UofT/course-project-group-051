package phase2.userbuilders;

import phase2.dataaccess.DataAccessInterface;
import phase2.users.PublicUser;

import java.util.Map;

/**
 * Provides a streamlined process of creating an PublicUser.
 */
public class PublicUserBuilder{


    /**
     * @return a fully filled in PublicUser.
     */
    public static PublicUser build(DataAccessInterface db, int id) {

        PublicUser publicUser = new PublicUser(id);
        updateUser(db.getUserInfo(id), publicUser);
        return publicUser;

    }
    /**
     * adds data to specific to this PublicUser.
     */
    public static void updateUser(Map<String, String> data, PublicUser publicUser) {
        publicUser.setLastName(data.get("lName"));
        publicUser.setFirstName(data.get("fName"));
        publicUser.setBio(data.get("bio"));
        publicUser.setImagePath(data.get("imgPath"));
        publicUser.setAge(data.get("age"));
        publicUser.setGender(data.get("gender"));
    }

}