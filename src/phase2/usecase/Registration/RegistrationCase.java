package phase2.usecase.Registration;

import javafx.scene.control.TextInputControl;
import phase2.dataaccess.DataAccessInterface;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class RegistrationCase {
    DataAccessInterface db;
    Map data;
    public RegistrationCase(DataAccessInterface db){
        this.db = db;
    }

    public int loginUser(String username, String password){
        return db.logIn(username, password);
    }

    public int createAccount(Map<String, TextInputControl> data){ //maybe return the constants for error in views?
        if (data.containsValue("")){
            return -1; // return RegistrationResults.MISSING;
        } else if (db.logIn(data.get("username").getText(), data.get("pw1").getText()) != -1){
            return -1; //return RegistrationResults.EXISTS;
        } else if (data.get("pw1") != data.get("pw2")){
            return -1; //return RegistrationResults.PASSWORDMATCH;
        } else {
            Date today = new Date();
            long diff = today.getTime() - new Date(data.get("DOB").getText()).getTime();
            int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            int id = db.createUser(data.get("lName").getText(), data.get("fName").getText(), data.get("pw1").getText(),
                    data.get("username").getText(), days / 365, data.get("gender").getText(),
                    data.get("preference").getText(), data.get("DOB").getText());
            return id; //return Integer.toString(id);

        }
    }
}
