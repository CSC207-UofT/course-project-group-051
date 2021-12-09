package phase2.userbuilders;

import phase2.constants.UserInfoConstants;
import phase2.dataaccess.DataAccessInterface;
import phase2.users.SelfUser;

import java.util.Map;

/**
 * Provides a streamlined process of creating an SelfUser.
 */
public class SelfUserBuilder{

    /**
     * @return a fully filled in SelfUser from db i.e. loginCase.
     */
    public static SelfUser build(DataAccessInterface db, int id) {

        SelfUser selfUser = new SelfUser(id);
        updateUser(db.getUserInfo(id), selfUser);
        return selfUser;

    }

    /**
     * adds data specific to SelfUser.
     */
    private static void updateUser(Map<String, String> data, SelfUser selfUser) {
        selfUser.setLastName(data.get(UserInfoConstants.LAST_NAME));
        selfUser.setFirstName(data.get(UserInfoConstants.FIRST_NAME));
        selfUser.setPassword(data.get(UserInfoConstants.PASSWORD));
        selfUser.setUsername(data.get(UserInfoConstants.UT_ID));
        selfUser.setAge(data.get(UserInfoConstants.AGE));
        selfUser.setGender(data.get(UserInfoConstants.GENDER));
        selfUser.setGenderPreference(data.get(UserInfoConstants.GENDER_PREFERENCE));
        selfUser.setImagePath(data.get(UserInfoConstants.IMAGE_PATH));
        selfUser.setBio(data.get(UserInfoConstants.BIO));
    }

}
