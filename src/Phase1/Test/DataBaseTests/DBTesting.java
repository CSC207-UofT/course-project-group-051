package Phase1.Test.DataBaseTests;

import Phase1.DataAccess.DataBaseAccess;
import javafx.scene.control.Alert;

import java.sql.*;
public class DBTesting {

    private Connection conn = null;
    private Statement stmt = null;

    public static void main(String[] args) {
        //DBTesting a = new DBTesting();
        //a.initialize();
        //a.loadBikeTable();
        DataBaseAccess db = new DataBaseAccess();
        db.resetDB();
        db.setUpDB();
        //System.out.println(db.createUser("testL", "testuusssF", "password", "testing666", 20, "male", "male"));
        //db.createDB();
        //System.out.println(db.getFirstName(db.logIn("testing666", "password")));

    }
}