package phase2.userbuilders;

import phase2.constants.UserInfoConstants;
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
    private static void updateUser(Map<String, String> data, PublicUser publicUser) {
        publicUser.setLastName(data.get(UserInfoConstants.LAST_NAME));
        publicUser.setFirstName(data.get(UserInfoConstants.FIRST_NAME));
        publicUser.setBio(data.get(UserInfoConstants.BIO));
        publicUser.setImagePath(data.get(UserInfoConstants.IMAGE_PATH));
        publicUser.setAge(data.get(UserInfoConstants.AGE));
        publicUser.setGender(data.get(UserInfoConstants.GENDER));
    }

}
