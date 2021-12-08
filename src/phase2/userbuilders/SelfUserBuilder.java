package phase2.userbuilders;

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
     * @return a fully filled in SelfUser from map i.e. registrationCase.
     */
    public SelfUser build(Map<String, String> data, DataAccessInterface db) {
        int id = db.createUser(data);
        SelfUser selfUser = new SelfUser(id);
        updateUser(data, selfUser);
        return selfUser;
    }

    /**
     * adds data specific to SelfUser.
     */
    public static void updateUser(Map<String, String> data, SelfUser selfUser) {
        selfUser.setLastName(data.get("lName"));
        selfUser.setFirstName(data.get("fName"));
        selfUser.setPassword(data.get("password"));
        selfUser.setUsername(data.get("UTorID"));
        selfUser.setAge(data.get("age"));
        selfUser.setGender(data.get("gender"));
        selfUser.setGenderPreference(data.get("genderPref"));
    }

}
