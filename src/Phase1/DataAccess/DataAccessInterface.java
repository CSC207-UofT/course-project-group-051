package Phase1.DataAccess;


import java.util.ArrayList;

/**
 * An interface that defines the methods that interact with the database.
 */
public interface DataAccessInterface {

    //takes the username and password of a user and return their personID.
    //if it is not in the database, it will return -1
    int logIn(String username, String password);

    //return the first name of the user with the id
    //return null if id doesn't exist
    String getFirstName(int id);

    //return the last name of the user with the id
    //return null if id doesn't exist
    String getLastName(int id);

    //return the username of the user with the id
    //return null if id doesn't exist
    String getUsername(int id);

    //return the password of the user with the id
    //return null if id doesn't exist
    String getPassword(int id);

    //return the gender of the user with the id
    //return null if id doesn't exist
    String getGender(int id);

    //return the bio of the user with the id
    //return null if id doesn't exist
    String getBio(int id);

    //return the genderPreference of the user with the id
    //return null if id doesn't exist
    String getGenderPreference(int id);

    //return the age of the user with the id
    //return -1 if id doesn't exist
    int getAge(int id);

    String getBirthday(int id);

    //return an ArrayList of integers representing the id of user's likes
    ArrayList<Integer> getLikes(int id);

    //return an ArrayList of integers representing the id of user's admires
    ArrayList<Integer> getAdmires(int id);

    ArrayList<Integer> getThreads(int id);

    //msg,senderID,receiverID
    ArrayList<String> getThread(int threadID);

    //msg,senderID,receiverID
    String getMessage(int messageID);

    boolean setFirstName(int id, String firstName);

    boolean setLastName(int id, String lastName);

    boolean setUsername(int id, String username);

    boolean setPassword(int id, String password);

    boolean setGender(int id, String gender);

    boolean setBio(int id, String bio);

    boolean setAge(int id, int age);

    boolean setBirthday(int id, String birthday);

    boolean setGenderPreference(int id, String genderPreference);

    boolean likeUser(int currUser, int likeID);

    boolean unlikeUser(int currUser, int likeID);

    boolean admireUser(int currUser, int admirerID);

    boolean stopAdmiringUser(int currUser, int admirerID);

    int createThread(int userID1, int userID2);

    int createMessage(int threadID, int sender, int receiver, String msg);

    ArrayList<String> getSwipeList(int id);

    int createUser(String lastName, String firstName, String password, String username, int age, String gender, String genderPreference, String birthday);


}
