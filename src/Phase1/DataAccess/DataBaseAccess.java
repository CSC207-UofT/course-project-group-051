package Phase1.DataAccess;

import Phase0.User;

import java.util.ArrayList;

public class DataBaseAccess implements DataAccessInterface{


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
}
