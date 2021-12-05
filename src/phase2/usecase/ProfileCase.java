package phase2.usecase;

import phase2.controllers.ProfileController;
import phase2.dataaccess.DataAccessInterface;

import java.util.Arrays;

public class ProfileCase {
    DataAccessInterface db;
    public ProfileCase(DataAccessInterface db){
        this.db = db;
    }

    public boolean checkValidDate(String birthday){
        String[] date = birthday.split(",");
        if(date.length != 3 || !Arrays.asList(ProfileController.VALID_MONTH).contains(date[0]) ||
                !(date[1].length() == 2 && this.isNumeric(date[1])) || !(date[2].length() == 4 && this.isNumeric(date[1]))){
            return false;
        }
        return true;
    }

    public boolean isNumeric(String string) {

        if(string == null || string.equals("")) {
            return false;
        }
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ignored) {
        }
        return false;
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
