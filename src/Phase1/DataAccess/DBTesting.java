package Phase1.DataAccess;

import javafx.scene.control.Alert;

import java.sql.*;

public class DBTesting {

    private Connection conn = null;
    private Statement stmt = null;

    public static void main(String[] args) {
        DBTesting a = new DBTesting();
        a.initialize();
        a.loadBikeTable();

    }
    public void initialize() {
        initializeDB();
    }

    private void initializeDB() {
        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./DB/USERS";
        final String USER = "";
        final String PASS = "";

        System.out.println("Attempting to connect to database");
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Successfully connected to database!");
        } catch (Exception e) {
            e.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        }
    }
    public void test(){
        String sql = "Select * from User;";

    }

    public void loadBikeTable() {
        try {
            String h2 = "SELECT * FROM USER;";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                int id = rs.getInt("PersonID");
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                int age = rs.getInt("Age");
                String gender = rs.getString("Gender");
                System.out.println(id + "\n"
                        + lastName + firstName + username + password + age + gender);
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
