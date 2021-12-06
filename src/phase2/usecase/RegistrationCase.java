package phase2.usecase;

import javafx.scene.control.TextInputControl;
import phase2.constants.Errors;
import phase2.dataaccess.DataAccessInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class RegistrationCase {
    DataAccessInterface db;

    public RegistrationCase(DataAccessInterface db){
        this.db = db;
    }

    public ArrayList<String> createAccount(Map<String, TextInputControl> data){ //maybe return the constants for error in views?
        Map<String, String> info = getStringMap(data);
        ArrayList<String> errors = new ArrayList<>(); // make into 1 string
        if (info.containsValue("")){
            errors.add(Errors.MISSING); // ADD THESE MESSAGES
        }
        if(!info.get("password").equals(info.get("passwordC"))){
            errors.add(Errors.PASSWORD_MATCH);
        }
        if (db.logIn(info.get("UTorID"), info.get("password")) != -1){
            errors.add(Errors.EXISTS); // ADD THESE MESSAGES
        }
        if(errors.isEmpty()) {
            db.createUser(info.get("lName"), info.get("fName"), info.get("password"),
                    info.get("UTorID"), Integer.parseInt(info.get("age")) , info.get("gender"),
                    info.get("genderPref"));
            return errors; //return Integer.toString(id);

        }
        return errors;
    }

    private Map<String, String> getStringMap(Map<String, TextInputControl> data){
        Map<String, String> info = new HashMap<>();
        for(String key: data.keySet()){
            info.put(key, data.get(key).getText());
        }
        return info;
    }
}
