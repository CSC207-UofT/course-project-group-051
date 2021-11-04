package Phase1.DataAccess;


import java.util.ArrayList;

/**
 * An interface that defines the methods that interact with the database.
 */
public interface DataAccessInterface {

    int logIn(String username, String password);

    String getFirstName(int id);

    String getLastName(int id);

    String getUsername(int id);

    String getPassword(int id);

    String getGender(int id);

    String getBio(int id);

    String getGenderPreference(int id);

    int getAge(int id);

    ArrayList<Integer> getLikes(int id);

    ArrayList<Integer> getAdmires(int id);

    ArrayList<String> getThread(int threadID);

    String getMessage(int messageID);

    boolean setFirstName(int id, String firstName);

    boolean setLastName(int id, String lastName);

    boolean setUsername(int id, String username);

    boolean setPassword(int id, String password);

    boolean setGender(int id, String gender);

    boolean setBio(int id, String bio);

    boolean setAge(int id, int age);

    boolean setGenderPreference(int id, String genderPreference);

    boolean likeUser(int currUser, int likeID);

    boolean unlikeUser(int currUser, int likeID);

    boolean admireUser(int currUser, int admirerID);

    boolean stopAdmiringUser(int currUser, int admirerID);

    int createThread(int userID1, int userID2);

    int createMessage(int threadID, int sender, int receiver);

    int createUser(String lastName, String firstName, String password, String username, int age, String gender, String genderPreference);


}
