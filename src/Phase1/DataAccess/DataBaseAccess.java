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
        int id = -1;
        try {
            String h2 = "select PERSONID from USER where username = '"+ username +"' and PASSWORD = '"+password+"';";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                id = rs.getInt("PersonID");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;

    }

    @Override
    public String getFirstName(int id) {
        String name = null;
        try {
            String h2 = "select FirstName from USER where PERSONID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                name = rs.getString("FirstName");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public String getLastName(int id) {
        String name = null;
        try {
            String h2 = "select LASTNAME from USER where PERSONID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                name = rs.getString("LASTNAME");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public String getUsername(int id) {
        String username = null;
        try {
            String h2 = "select USERNAME from USER where PERSONID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                username = rs.getString("USERNAME");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return username;
    }

    @Override
    public String getPassword(int id) {
        String password = null;
        try {
            String h2 = "select PASSWORD from USER where PERSONID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                password = rs.getString("PASSWORD");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    @Override
    public String getGender(int id) {
        String gender = null;
        try {
            String h2 = "select gender from USER where PERSONID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                gender = rs.getString("gender");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gender;
    }

    @Override
    public String getBio(int id) {
        String bio = null;
        try {
            String h2 = "select bio from USER where PERSONID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                bio = rs.getString("bio");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bio;
    }

    @Override
    public String getGenderPreference(int id) {
        String genderPreference = null;
        try {
            String h2 = "select genderPreference from USER where PERSONID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                genderPreference = rs.getString("genderPreference");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genderPreference;
    }

    @Override
    public int getAge(int id) {
        int age = -1;
        try {
            String h2 = "select age from USER where PERSONID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                age = rs.getInt("age");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return age;
    }

    @Override
    public ArrayList<Integer> getLikes(int id) {
        ArrayList<Integer> likes = new ArrayList<>();
        try {
            String h2 = "select age from USER where PERSONID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                String[] temp = rs.getString("Likes").split(",", -1);
                for(String x: temp){
                    likes.add(Integer.parseInt(x));
                }
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return likes;
    }

    @Override
    public ArrayList<Integer> getAdmires(int id) {
        ArrayList<Integer> admires = new ArrayList<>();
        try {
            String h2 = "select admires from USER where PERSONID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                String[] temp = rs.getString("admires").split(",", -1);
                for(String x: temp){
                    admires.add(Integer.parseInt(x));
                }
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admires;
    }

    @Override
    public ArrayList<Integer> getThreads(int id) {
        ArrayList<Integer> threads = new ArrayList<>();
        try {
            String h2 = "select threads from USER where PERSONID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                String[] temp = rs.getString("threads").split(",", -1);
                for(String x: temp){
                    threads.add(Integer.parseInt(x));
                }
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return threads;
    }

    @Override
    public ArrayList<String> getThread(int threadID) {
        ArrayList<String> thread = new ArrayList<>();
        try {
            String h2 = "select Messages, userID1, userID2 from threads where threadID = "+ threadID +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                String[] Messages = rs.getString("Messages").split(",", -1);
                //String userID1 = rs.getString("userID1");
                //String userID2 = rs.getString("userID1");
                for(String x: Messages){
                    thread.add(this.getMessage(Integer.parseInt(x)));
                }
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thread;
    }

    @Override
    public String getMessage(int messageID) {
        String message = "";
        try {
            String h2 = "select Messages, sender, receiver from messages where messageID = "+ messageID +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                message = rs.getString("Messages");
                String sender = rs.getString("sender");
                String receiver = rs.getString("receiver");
                message = message + "," + sender + "," + receiver;
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;

    }

    @Override
    public boolean setFirstName(int id, String firstName) {
        boolean rs = false;
        try {
            String h2 = "update user set firstName = " + firstName +" where PERSONID = " + id + ";";
             rs= stmt.execute(h2);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean setLastName(int id, String lastName) {
        boolean rs = false;
        try {
            String h2 = "update user set lastName = " + lastName +" where PERSONID = " + id + ";";
            rs= stmt.execute(h2);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean setUsername(int id, String username) {
        boolean rs = false;
        try {
            String h2 = "update user set username = " + username +" where PERSONID = " + id + ";";
            rs= stmt.execute(h2);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean setPassword(int id, String password) {
        boolean rs = false;
        try {
            String h2 = "update user set password = " + password +" where PERSONID = " + id + ";";
            rs= stmt.execute(h2);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean setGender(int id, String gender) {
        boolean rs = false;
        try {
            String h2 = "update user set gender = " + gender +" where PERSONID = " + id + ";";
            rs= stmt.execute(h2);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean setBio(int id, String bio) {
        boolean rs = false;
        try {
            String h2 = "update user set bio = " + bio +" where PERSONID = " + id + ";";
            rs= stmt.execute(h2);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean setAge(int id, int age) {
        boolean rs = false;
        try {
            String h2 = "update user set age = " + age +" where PERSONID = " + id + ";";
            rs= stmt.execute(h2);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean setGenderPreference(int id, String genderPreference) {
        boolean rs = false;
        try {
            String h2 = "update user set genderPreference = " + genderPreference +" where PERSONID = " + id + ";";
            rs= stmt.execute(h2);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean likeUser(int currUser, int likeID) {
        boolean rs = false;
        //not done
        try {
            String h2 = "update user set likeID = " + likeID +" where PERSONID = " + currUser + ";";
            rs= stmt.execute(h2);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
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
