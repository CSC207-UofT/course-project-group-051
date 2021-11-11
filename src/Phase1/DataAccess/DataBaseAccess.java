package Phase1.DataAccess;


import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DataBaseAccess implements DataAccessInterface{

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
            String h2 = "select PersonID from USER where username = '"+ username +"' and PASSWORD = '"+password+"';";
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
            String h2 = "select FirstName from USER where PersonID = "+ id +";";
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
            String h2 = "select LASTNAME from USER where PersonID = "+ id +";";
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
            String h2 = "select USERNAME from USER where PersonID = "+ id +";";
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
            String h2 = "select PASSWORD from USER where PersonID = "+ id +";";
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
            String h2 = "select gender from USER where PersonID = "+ id +";";
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
            String h2 = "select bio from USER where PersonID = "+ id +";";
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
            String h2 = "select genderPreference from USER where PersonID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                genderPreference = rs.getString("GENDERPREFERENCE");
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
            String h2 = "select age from USER where PersonID = "+ id +";";
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
    public String getImgPath(int id) {
        String path = null;
        try {
            String h2 = "select imgLocation from USER where PersonID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                path = rs.getString("imgLocation");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    @Override
    public String getBirthday(int id) {
        String birthday = null;
        try {
            String h2 = "select birthday from USER where PersonID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                birthday = rs.getString("birthday");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return birthday;
    }

    @Override
    public ArrayList<Integer> getLikes(int id) {
        ArrayList<Integer> likes = new ArrayList<>();
        try {
            String h2 = "select likes from USER where PersonID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                String[] temp = rs.getString("Likes").split(",", -1);
                for(String x: temp){
                    if(!x.equals(""))
                    {
                        likes.add(Integer.parseInt(x));
                    }
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
            String h2 = "select admires from USER where PersonID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                String[] temp = rs.getString("admires").split(",", -1);
                for(String x: temp){
                    admires.add(Integer.parseInt(x));
                    if(!x.equals(""))
                    {
                        admires.add(Integer.parseInt(x));
                    }
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
            String h2 = "select threads from USER where PersonID = "+ id +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                String[] temp = rs.getString("threads").split(",", -1);
                for(String x: temp){
                    if(!x.equals(""))
                    {
                        threads.add(Integer.parseInt(x));
                    }
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
                for(String x: Messages){
                    if(!x.equals(""))
                    {
                        thread.add(this.getMessage(Integer.parseInt(x)));
                    }
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
            String h2 = "update user set firstName = '" + firstName +"' where PERSONID = " + id + ";";
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
            String h2 = "update user set lastName = '" + lastName +"' where PERSONID = " + id + ";";
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
            String h2 = "update user set username = '" + username +"' where PERSONID = " + id + ";";
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
            String h2 = "update user set password = '" + password +"' where PERSONID = " + id + ";";
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
            String h2 = "update user set gender = '" + gender +"' where PERSONID = " + id + ";";
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
            String h2 = "update user set bio = '" + bio +"' where PERSONID = " + id + ";";
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
    public boolean setBirthday(int id, String birthday) {
        boolean rs = false;
        try {
            String h2 = "update user set birthday = '" + birthday +"' where PERSONID = " + id + ";";
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
    public boolean setImgPath(int id, String path) {
        boolean rs = false;
        try {
            String h2 = "update user set IMGLOCATION = '" + path +"' where PERSONID = " + id + ";";
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
            String h2 = "update user set genderPreference = '" + genderPreference +"' where PERSONID = " + id + ";";
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
        StringBuilder like;
        try {
            if(this.getLikes(currUser).contains(likeID)){
                return false;
            }
            else{
                ArrayList<Integer> likes = this.getLikes(currUser);
                likes.add(likeID);
                like = new StringBuilder(likes.remove(0).toString());
                for(int x: likes){
                    like.append(",").append(x);
                }
            }

            String h2 = "update user set likes = '" + like +"' where PERSONID = " + currUser + ";";
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
        boolean rs = false;
        StringBuilder like = new StringBuilder();
        try {
            if(!this.getLikes(currUser).contains(likeID)){
                return false;
            }
            else{
                ArrayList<Integer> likes = this.getLikes(currUser);
                likes.remove(likeID);
                if(likes.size() != 0){
                    like = new StringBuilder(likes.remove(0).toString());
                    for(int x: likes){
                        like.append(",").append(x);
                    }
                }
            }

            String h2 = "update user set likes = '" + like +"' where PERSONID = " + currUser + ";";
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
    public boolean admireUser(int currUser, int admirerID) {
        boolean rs = false;
        StringBuilder admire;
        try {
            if(this.getAdmires(currUser).contains(admirerID)){
                return false;
            }
            else{
                ArrayList<Integer> admirer = this.getAdmires(currUser);
                admirer.add(admirerID);
                admire = new StringBuilder(admirer.remove(0).toString());
                for(int x: admirer){
                    admire.append(",").append(x);
                }
            }

            String h2 = "update user set ADMIRES = '" + admire +"' where PERSONID = " + currUser + ";";
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
    public boolean stopAdmiringUser(int currUser, int admirerID) {
        boolean rs = false;
        StringBuilder admire = new StringBuilder();
        try {
            if(!this.getAdmires(currUser).contains(admirerID)){
                return false;
            }
            else{
                ArrayList<Integer> admirer = this.getAdmires(currUser);
                admirer.remove(admirerID);
                if(admirer.size() != 0){
                    admire = new StringBuilder(admirer.remove(0).toString());
                    for(int x: admirer){
                        admire.append(",").append(x);
                    }
                }
            }

            String h2 = "update user set ADMIRES = '" + admire +"' where PERSONID = " + currUser + ";";
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
    public int checkConversation(int userID1, int userID12) {
        ArrayList<Integer> threads1 = this.getThreads(userID1);
        ArrayList<Integer> threads2 = this.getThreads(userID12);
        for(int x: threads1){
            if(threads2.contains(x)){
                return x;
            }
        }
        return -1;
    }

    @Override
    public int createThread(int userID1, int userID2) {
        if(this.checkConversation(userID1, userID2) != -1){
            return -1;
        }
        int id = this.getNewThreadID();
        try {
            String h2 = "insert into THREADS values ("+id+", '');";
            stmt.execute(h2);
            this.addThread(userID1, id);
            this.addThread(userID2, id);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    private void addThread(int userID, int threadID){
        StringBuilder thread;
        try {
            ArrayList<Integer> threads = this.getThreads(userID);
            threads.add(threadID);
            thread = new StringBuilder(threads.remove(0).toString());
            for(int x: threads){
                thread.append(",").append(x);
            }

            String h2 = "update user set THREADS = '" + thread +"' where PERSONID = " + userID + ";";
            stmt.execute(h2);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getNewThreadID(){
        int id = -1;
        try {
            String h2 = "select count(threadID) from threads;";
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
    public void createMessage(int threadID, int sender, int receiver, String msg) {
        int id = this.getNewMsgID();
        try {
            String h2 = "insert into MESSAGES values ("+id+", '"+msg+"', '"+sender+"', '"+ receiver +"');";
            stmt.execute(h2);
            this.addMessage(id, threadID);
            this.addMessage(id, threadID);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Integer> getSwipeList(int id) {
        String genderPref;
        ArrayList<Integer> swipes = new ArrayList<>();
        genderPref = this.getGenderPreference(id);
        if(genderPref != null){
            try {
                String h2 = "select personId from user where genderPreference = '"+ genderPref+"' and personId != "+id+";";
                ResultSet rs = stmt.executeQuery(h2);
                while (rs.next()) {
                    String list = rs.getString("genderPreference");
                    for(String x : list.split(",")){
                        if(!x.equals(""))
                        {
                            swipes.add(Integer.parseInt(x));
                        }
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
        }
        return swipes;
    }

    private void addMessage(int messageID, int threadID){
        StringBuilder message;
        try {
            ArrayList<Integer> messages = this.getThreadMsg(threadID);
            messages.add(messageID);
            message = new StringBuilder(messages.remove(0).toString());
            for(int x: messages){
                message.append(",").append(x);
            }

            String h2 = "update THREADS set MESSAGES = " + message +" where THREADID = " + threadID + ";";
            stmt.execute(h2);
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getNewMsgID(){
        int id = -1;
        try {
            String h2 = "select count(MessageID) from Messages;";
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

    public ArrayList<Integer> getThreadMsg(int threadID) {
        ArrayList<Integer> thread = new ArrayList<>();
        try {
            String h2 = "select Messages from threads where threadID = "+ threadID +";";
            ResultSet rs = stmt.executeQuery(h2);
            while (rs.next()) {
                String[] Messages = rs.getString("Messages").split(",", -1);
                for(String x: Messages){
                    if(!x.equals(""))
                    {
                        thread.add(Integer.parseInt(x));
                    }
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
    public int createUser(String lastName, String firstName, String password, String username, int age, String gender, String genderPreference, String birthday) {
        int id = this.getNextUser();
        try {
            String h2 = "insert into user values ("+id+", '"+lastName+"', '"+firstName+"', '"+username+"', '"+password+"', "+age+", '"+gender+"', '"+genderPreference+"', '', '', '', '', '"+ birthday+"', '');";
            stmt.execute(h2);

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
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Successfully connected to database!");
        } catch (Exception e) {
            e.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        }
    }
}
