package phase2.usecase;

import javafx.scene.control.TextInputControl;
import phase2.constants.Errors;
import phase2.dataaccess.DataAccessInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;


public class RegistrationCase {
    DataAccessInterface db;

    public RegistrationCase(DataAccessInterface db){
        this.db = db;
    }

    public int loginUser(String username, String password){
        return db.logIn(username, password);
    }

    public ArrayList<String> createAccount(Map<String, TextInputControl> data){ //maybe return the constants for error in views?
        ArrayList<String> errors = new ArrayList<>(); // make into 1 string
        if (data.containsValue("")){
            errors.add(Errors.MISSING); // ADD THESE MESSAGES
        }
        if (db.logIn(data.get("username").getText(), data.get("pw1").getText()) != -1){
            errors.add(Errors.EXISTS); // ADD THESE MESSAGES
        }
        if(errors.isEmpty()) {
            db.createUser(data.get("lName").getText(), data.get("fName").getText(), data.get("pw1").getText(),
                    data.get("username").getText(), Integer.parseInt(data.get("age").getText()), data.get("gender").getText(),
                    data.get("preference").getText(), data.get("DOB").getText());
            return errors; //return Integer.toString(id);

        }
        return errors;
    }
}
