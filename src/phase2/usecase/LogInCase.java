package phase2.usecase;

import phase2.dataaccess.DataAccessInterface;

public class LogInCase {

    DataAccessInterface db;
    public LogInCase(DataAccessInterface db){
        this.db = db;
    }

    public int loginUser(String username, String password){
        return db.logIn(username, password);
    }
}
