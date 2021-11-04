package Phase1.DataAccess;


import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAccess implements DataAccessInterface{

    private Connection conn = null;
    private Statement stmt = null;


    public DataBaseAccess(){
        connectDB();
    }

    private int getNextUser(){
        int id = -1;
        try {
            String h2 = "select count(personID) from user;";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                id = rs.getInt("count(PersonID)");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id + 1;
    }

    @Override
    public int logIn(String username, String password) {
        return 0;
    }

    @Override
    public String getFirstName(int id) {
        return null;
    }

    @Override
    public String getLastName(int id) {
        return null;
    }

    @Override
    public String getUsername(int id) {
        return null;
    }

    @Override
    public String getPassword(int id) {
        return null;
    }

    @Override
    public String getGender(int id) {
        return null;
    }

    @Override
    public String getBio(int id) {
        return null;
    }

    @Override
    public String getGenderPreference(int id) {
        return null;
    }

    @Override
    public int getAge(int id) {
        return 0;
    }

    @Override
    public ArrayList<Integer> getLikes(int id) {
        return null;
    }

    @Override
    public ArrayList<Integer> getAdmires(int id) {
        return null;
    }

    @Override
    public ArrayList<String> getThread(int threadID) {
        return null;
    }

    @Override
    public String getMessage(int messageID) {
        return null;
    }

    @Override
    public boolean setFirstName(int id, String firstName) {
        return false;
    }

    @Override
    public boolean setLastName(int id, String lastName) {
        return false;
    }

    @Override
    public boolean setUsername(int id, String username) {
        return false;
    }

    @Override
    public boolean setPassword(int id, String password) {
        return false;
    }

    @Override
    public boolean setGender(int id, String gender) {
        return false;
    }

    @Override
    public boolean setBio(int id, String bio) {
        return false;
    }

    @Override
    public boolean setAge(int id, int age) {
        return false;
    }

    @Override
    public boolean setGenderPreference(int id, String genderPreference) {
        return false;
    }

    @Override
    public boolean likeUser(int currUser, int likeID) {
        return false;
    }

    @Override
    public boolean unlikeUser(int currUser, int likeID) {
        return false;
    }

    @Override
    public boolean admireUser(int currUser, int admirerID) {
        return false;
    }

    @Override
    public boolean stopAdmiringUser(int currUser, int admirerID) {
        return false;
    }

    @Override
    public int createThread(int userID1, int userID2) {
        return 0;
    }

    @Override
    public int createMessage(int threadID, int sender, int receiver) {
        return 0;
    }

    @Override
    public int createUser(String lastName, String firstName, String password, String username, int age, String gender, String genderPreference) {
        int id = this.getNextUser();
        try {
            String h2 = "insert into user values ("+id+", '"+lastName+"', '"+firstName+"', '"+username+"', '"+password+"', "+age+", '"+gender+"', '"+genderPreference+"', '', '', '', '');";
            boolean rs = stmt.execute(h2);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private void connectDB() {
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
}
