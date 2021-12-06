package phase2.usecase;

import phase2.controllers.ProfileController;
import phase2.dataaccess.DataAccessInterface;

import java.util.Arrays;

public class ProfileCase {
    DataAccessInterface db;
    public ProfileCase(DataAccessInterface db){
        this.db = db;
    }

    public void updateUser(int id, String[] info){
        db.setFirstName(id, info[0]);
        db.setLastName(id, info[1]);
        db.setBirthday(id, info[2]);
        db.setImgPath(id, info[3]);
        db.setGender(id, info[4]);
        db.setGenderPreference(id, info[5]);
        db.setUsername(id, info[6]);
        db.setBio(id, info[7]);
        db.setPassword(id, info[8]);
    }
}
