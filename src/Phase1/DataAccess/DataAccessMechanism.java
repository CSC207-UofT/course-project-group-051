package Phase1.DataAccess;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * An interface that defines the methods that interact with the database.
 */
public abstract class DataAccessMechanism {

    //takes the username and password of a user and return their personID.
    //if it is not in the database, it will return -1
    public abstract int logIn(String username, String password);

    //return the first name of the user with the id
    //return null if id doesn't exist
    public abstract String getFirstName(int id);

    //return the last name of the user with the id
    //return null if id doesn't exist
    public abstract String getLastName(int id);

    //return the username of the user with the id
    //return null if id doesn't exist
    public abstract String getUsername(int id);

    //return the password of the user with the id
    //return null if id doesn't exist
    public abstract String getPassword(int id);

    //return the gender of the user with the id
    //return null if id doesn't exist
    public abstract String getGender(int id);

    //return the bio of the user with the id
    //return null if id doesn't exist
    public abstract String getBio(int id);

    //return the genderPreference of the user with the id
    //return null if id doesn't exist
    public abstract String getGenderPreference(int id);

    //return the age of the user with the id
    //return -1 if id doesn't exist
    public abstract int getAge(int id);

    //return the imgLocation of the user with the id
    //return null if id doesn't exist
    public abstract String getImgPath(int id);


    //return the birthday of the user with the id
    //return null if id doesn't exist
    public abstract String getBirthday(int id);

    //return an ArrayList of integers representing the id of user's likes
    public abstract ArrayList<Integer> getLikes(int id);

    //return an ArrayList of integers representing the id of user's admires
    public abstract ArrayList<Integer> getAdmires(int id);

    //return an ArrayList of integers representing the id of user's Threads
    public abstract ArrayList<Integer> getThreads(int id);

    //return the thread with the given threadID as an arraylist of Strings in the format below
    //"msg1,senderID,receiverID"
    //"msg2,senderID,receiverID"
    //"msg3,senderID,receiverID"
    public abstract ArrayList<String> getThread(int threadID);

    //msg,senderID,receiverID
    public abstract String getMessage(int messageID);

    //takes the user's id and the firstName and set said user's first name as firstName
    //return false if failed
    public abstract boolean setFirstName(int id, String firstName);

    //takes the user's id and the lastName and set said user's last name as lastName
    //return false if failed
    public abstract boolean setLastName(int id, String lastName);

    //takes the user's id and the username and set said user's username as username
    //return false if failed
    public abstract boolean setUsername(int id, String username);

    //takes the user's id and the password and set said user's password as password
    //return false if failed
    public abstract boolean setPassword(int id, String password);

    //takes the user's id and the gender and set said user's gender as gender
    //return false if failed
    public abstract boolean setGender(int id, String gender);

    //takes the user's id and the bio and set said user's bio as bio
    //return false if failed
    public abstract boolean setBio(int id, String bio);

    //takes the user's id and the bio and set said user's bio as bio
    //return false if failed
    public abstract boolean setAge(int id, int age);

    //takes the user's id and the birthday and set said user's birthday as birthday
    //return false if failed
    public abstract boolean setBirthday(int id, String birthday);

    //takes the user's id and the path and set said user's imgLocation as path
    //return false if failed
    public abstract boolean setImgPath(int id, String path);

    //takes the user's id and the genderPreference and set said user's gender preference as genderPreference
    //return false if failed
    public abstract boolean setGenderPreference(int id, String genderPreference);

    //takes the current user's id and the person they like's id.
    //add the likeID to the currUser's list of likes
    //return false if failed
    public abstract boolean likeUser(int currUser, int likeID);

    //takes the current user's id and the person they like's id.
    //remove the likeID to the currUser's list of likes
    //return false if failed
    public abstract boolean unlikeUser(int currUser, int likeID);

    //takes the current user's id and the person they admires' id.
    //add the admirerID to the currUser's list of admires
    //return false if failed
    public abstract boolean admireUser(int currUser, int admirerID);

    //takes the current user's id and the person they admires' id.
    //remove the admirerID to the currUser's list of admires
    //return false if failed
    public abstract boolean stopAdmiringUser(int currUser, int admirerID);

    //checks if two user have a thread between them if yes return the threadID, if no return -1
    public abstract int checkConversation(int userID1, int userID12);

    //takes two users' id and create a thread between them
    //return -1 if there is already a thread and the threadId if there is no thread between them
    public abstract int createThread(int userID1, int userID2);

    //adds the msg into the given thread id base on the given sender, receiver and threadID.
    public abstract void createMessage(int threadID, int sender, int receiver, String msg);

    //gets of list of id with the required gender base on the gender preference of the parameter id
    public abstract ArrayList<Integer> getSwipeList(int id);

    //creates a new user in the database using the parameters below.
    //returns their PersonID and -1 if invalid parameters are given.
    public abstract int createUser(String lastName, String firstName, String password, String username, int age, String gender,
                                   String genderPreference, String birthday);

    public abstract void closeDB() throws SQLException;

    public abstract ArrayList getMatches(int id);

}