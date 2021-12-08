package phase2.usecase;

import phase2.controllers.ProfileController;
import phase2.dataaccess.DataAccessInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProfileCase {
    DataAccessInterface db;
    public ProfileCase(DataAccessInterface db){
        this.db = db;
    }

    public void updateUser(int id, String[] info){
        Map<String, String> updates = new HashMap<>();
        updates.put("uTID", info[0]);
        updates.put("password", info[0]);
        updates.put("firstName", info[0]);
        updates.put("lastName", info[0]);
        updates.put("age", info[0]);
        updates.put("gender", info[0]);
        updates.put("genderPref", info[0]);
        updates.put("Bio", info[0]);
        updates.put("imgPath", info[0]);
        db.updateUserInfo(id, updates);
    }


}
