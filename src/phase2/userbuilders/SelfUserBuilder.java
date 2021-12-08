package phase2.userbuilders;

import phase2.dataaccess.DataAccessInterface;
import phase2.dataaccess.DataAccessInterface2;
import phase2.users.PublicUser;
import phase2.users.SelfUser;

import java.util.Map;

public class SelfUserBuilder implements UserBuilder {

    /**
     * @return a fully filled in SelfUser from db i.e. loginCase.
     */
    public SelfUser build(DataAccessInterface2 db, int id) {

        SelfUser selfUser = new SelfUser(id);
        updateUser(db.getUserInfo(id), selfUser);
        return selfUser;

    }
    /**
     * @return a fully filled in PublicUser from map i.e. registrationCase.
     */
    public SelfUser build(Map<String, String> data, DataAccessInterface2 db) {
        int id = db.createUser(data);
        SelfUser selfUser = new SelfUser(id);
        updateUser(data, selfUser);
        return selfUser;
    }

    /**
     * adds data to selfUser.
     */
    public void updateUser(Map<String, String> data, SelfUser selfUser) {
        selfUser.setlName(data.get("lName"));
        selfUser.setfName(data.get("fName"));
        selfUser.setPassword(data.get("password"));
        selfUser.setUsername(data.get("UTorID"));
        selfUser.setAge(data.get("age"));
        selfUser.setGender(data.get("gender"));
        selfUser.setGenderPreference(data.get("genderPref"));
    }
    /**
     * @return a fully filled in SelfUser.
     */
//    @Override
//    public SelfUser getResult() {
//        buildBaseUser(result, db);
//        buildSpecificUser();
//        return result;
//    }

}
