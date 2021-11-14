package Phase1.DataAccess;


import java.sql.SQLException;
import java.util.ArrayList;

/**
 * An interface that defines the methods that interact with the database.
 */
public interface DataAccessInterface {

    /**
     * takes the username and password of a user and return their personID.
     * if it is not in the database, it will return -1
     */
    int logIn(String username, String password);

    /**
     * return the first name of the user with the id
     * return null if id doesn't exist
     */
    String getFirstName(int id);

    /**
     * return the last name of the user with the id
     * return null if id doesn't exist
     */
    String getLastName(int id);

    /**
     * return the username of the user with the id
     * return null if id doesn't exist
     */
    String getUsername(int id);

    /**
     * return the password of the user with the id
     * return null if id doesn't exist
     */
    String getPassword(int id);

    /**
     * return the gender of the user with the id
     * return null if id doesn't exist
     */
    String getGender(int id);

    /**
     * return the bio of the user with the id
     * return null if id doesn't exist
     */
    String getBio(int id);

    /**
     * return the genderPreference of the user with the id
     * return null if id doesn't exist
     */
    String getGenderPreference(int id);

    /**
     * return the age of the user with the id
     * return -1 if id doesn't exist
     */
    int getAge(int id);

    /**
     * return the imgLocation of the user with the id
     * return null if id doesn't exist
     */
    String getImgPath(int id);


    /**
     * return the birthday of the user with the id
     * return null if id doesn't exist
     */
    String getBirthday(int id);

    /**
     * return an ArrayList of integers representing the id of user's likes
     */
    ArrayList<Integer> getLikes(int id);

    /**
     * return an ArrayList of integers representing the id of user's admires
     */
    ArrayList<Integer> getAdmires(int id);

    /**
     * return an ArrayList of integers representing the id of user's Threads
     */
    ArrayList<Integer> getThreads(int id);

    /**
     * return the thread with the given threadID as an arraylist of Strings in the format below
     * "msg1,senderID,receiverID"
     * "msg2,senderID,receiverID"
     * "msg3,senderID,receiverID"
     */
    ArrayList<String> getThread(int threadID);

    /**
     * msg,senderID,receiverID
     */
    String getMessage(int messageID);

    /**
     * takes the user's id and the firstName and set said user's first name as firstName
     * return false if failed
     */
    boolean setFirstName(int id, String firstName);

    /**
     * takes the user's id and the lastName and set said user's last name as lastName
     * return false if failed
     */
    boolean setLastName(int id, String lastName);

    /**
     * takes the user's id and the username and set said user's username as username
     * return false if failed
     */
    boolean setUsername(int id, String username);

    /**
     * takes the user's id and the password and set said user's password as password
     * return false if failed
     */
    boolean setPassword(int id, String password);

    /**
     * takes the user's id and the gender and set said user's gender as gender
     * return false if failed
     */
    boolean setGender(int id, String gender);

    /**
     * takes the user's id and the bio and set said user's bio as bio
     * return false if failed
     */
    boolean setBio(int id, String bio);

    /**
     * takes the user's id and the bio and set said user's bio as bio
     * return false if failed
     */
    boolean setAge(int id, int age);

    /**
     * takes the user's id and the birthday and set said user's birthday as birthday
     * return false if failed
     */
    boolean setBirthday(int id, String birthday);

    /**
     * takes the user's id and the path and set said user's imgLocation as path
     * return false if failed
     */
    boolean setImgPath(int id, String path);

    /**
     * takes the user's id and the genderPreference and set said user's gender preference as genderPreference
     * return false if failed
     */
    boolean setGenderPreference(int id, String genderPreference);

    /**
     * takes the current user's id and the person they like's id.
     * add the likeID to the currUser's list of likes
     * return false if failed
     */
    boolean likeUser(int currUser, int likeID);

    /**
     * takes the current user's id and the person they like's id.
     * remove the likeID to the currUser's list of likes
     * return false if failed
     */
    boolean unlikeUser(int currUser, int likeID);

    /**
     * takes the current user's id and the person they admires' id.
     * add the admirerID to the currUser's list of admires
     * return false if failed
     */
    boolean admireUser(int currUser, int admirerID);

    /**
     * takes the current user's id and the person they admires' id.
     * remove the admirerID to the currUser's list of admires
     * return false if failed
     */
    boolean stopAdmiringUser(int currUser, int admirerID);

    /**
     * checks if two user have a thread between them if yes return the threadID, if no return -1
     */
    int checkConversation(int userID1, int userID12);

    /**
     * takes two users' id and create a thread between them
     * return -1 if there is already a thread and the threadId if there is no thread between them
     */
    int createThread(int userID1, int userID2);

    /**
     * adds the msg into the given thread id base on the given sender, receiver and threadID.
     */
    void createMessage(int threadID, int sender, int receiver, String msg);

    /**
     * gets of list of id with the required gender base on the gender preference of the parameter id
     */
    ArrayList<Integer> getSwipeList(int id);

    /**
     * creates a new user in the database using the parameters below.
     * returns their PersonID and -1 if invalid parameters are given.
     */
    int createUser(String lastName, String firstName, String password, String username, int age, String gender,
                   String genderPreference, String birthday);

    void closeDB() throws SQLException;

    ArrayList getMatches(int id);
}
