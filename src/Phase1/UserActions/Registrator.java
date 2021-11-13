package Phase1.UserActions;

import Phase1.DataAccess.DataAccessInterface;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Registrator implements Transitionable {
    private DataAccessInterface db;

    public Registrator(DataAccessInterface db) {
        this.db = db;
    }

    public String createUser(Map<String, String> data) throws Exception {
        if (data.containsValue("")){
            return RegistrationResults.MISSING;
        } else if (db.logIn(data.get("username"), data.get("pw1")) != -1){
            return RegistrationResults.EXISTS;
        } else if (data.get("pw1") != data.get("pw2")){
            return RegistrationResults.PASSWORDMATCH;
        } else {
            Date today = new Date();
            long diff = today.getTime() - new Date(data.get("DOB")).getTime();
            int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            FileInputStream file = new FileInputStream(data.get("imagePath"));
            int id = db.createUser(data.get("lName"), data.get("fName"), data.get("pw1"), data.get("username"),
                    days / 365, data.get("gender"), data.get("preference"), data.get("DOB")); // BENNY TODO : Create User
            db.setBio(id, data.get("bio")); // FIXME: Move to Profile View and Actions
            db.setImgPath(id, data.get("imagePath")); // FIXME: Move to Profile View and Actions
            return Integer.toString(id);

        }

    }

    @Override
    public void transition() {

    }
}
