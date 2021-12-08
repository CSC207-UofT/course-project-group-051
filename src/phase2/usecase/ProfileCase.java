package phase2.usecase;

import phase2.controllers.ControllerFactory;
import phase2.controllers.ProfileController;
import phase2.dataaccess.DataAccessInterface;
import phase2.userbuilders.SelfUserBuilder;
import phase2.users.SelfUser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProfileCase {
    DataAccessInterface db;
    public ProfileCase(DataAccessInterface db){
        this.db = db;
    }

    public void updateUser(int id, Map<String, String> info){
//        Map<String, String> updates = new HashMap<>();
//        updates.put("uTID", info[0]);
//        updates.put("password", info[1]);
//        updates.put("firstName", info[2]);
//        updates.put("lastName", info[3]);
//        updates.put("age", info[4]);
//        updates.put("gender", info[5]);
//        updates.put("genderPref", info[6]);
//        updates.put("bio", info[7]);
//        updates.put("imgPath", info[8]);
        db.updateUserInfo(id, info);
        SelfUser user = SelfUserBuilder.build(db, id);
        ControllerFactory.getInstance().setCurrentUser(user);
    }


}
