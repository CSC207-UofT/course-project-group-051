package phase2.dataaccess;


import java.sql.SQLException;
import java.util.ArrayList;

/**
 * An interface that defines the methods that interact with the database.
 */
public interface DataAccessInterface {

    /**
     * @param username the UTorID of the user you are trying to log into.
     * @param password the password of the user you are trying to log into.
     * @return returns the id of the user, if it is not in the database, it will return -1
     */
    int logIn(String username, String password);

    /**
     * @param id the id of the user's info you are requesting
     * @return the first name of the user with the id, return null if id doesn't exist
     */
    String getFirstName(int id);

    /**
     * @param id the id of the user's info you are requesting
     * @return the last name of the user with the id, return null if id doesn't exist
     */
    String getLastName(int id);

    /**
     * @param id the id of the user's info you are requesting
     * return the username of the user with the id, return null if id doesn't exist
     */
    String getUsername(int id);

    /**
     * @param id the id of the user's info you are requesting
     * return the password of the user with the id, return null if id doesn't exist
     */
    String getPassword(int id);

    /**
     * @param id the id of the user's info you are requesting
     * return the gender of the user with the id, return null if id doesn't exist
     */
    String getGender(int id);

    /**
     * @param id the id of the user's info you are requesting
     * return the bio of the user with the id, return null if id doesn't exist
     */
    String getBio(int id);

    /**
     * @param id the id of the user's info you are requesting
     * return the genderPreference of the user with the id, return null if id doesn't exist
     */
    String getGenderPreference(int id);


    /**
     * @param id the id of the user's info you are requesting
     * return the imgLocation of the user with the id, return null if id doesn't exist
     */
    String getImgPath(int id);


    /**
     * @param id the id of the user's info you are requesting
     * return the birthday of the user with the id, return null if id doesn't exist
     */
    String getBirthday(int id);

    /**
     * @param id the id of the user's info you are requesting, return an ArrayList of integers representing the id of user's likes
     */
    ArrayList<Integer> getLikes(int id);

    /**
     * @param id the id of the user's info you are requesting, return an ArrayList of integers representing the id of user's admires
     */
    ArrayList<Integer> getAdmires(int id);

    /**
     * @param id the id of the user's info you are requesting, return an ArrayList of integers representing the id of user's Threads
     */
    ArrayList<Integer> getThreads(int id);

    /**
     * @param threadID the thread's id
     * @return the thread with the given threadID as an arraylist of String[] in the format below
     * {"msg1","senderID","receiverID"}
     * {"msg2","senderID","receiverID"}
     * {"msg3","senderID","receiverID"}
     */
    ArrayList<String[]> getThread(int threadID);

    public int getAge(int id);
    /**
     * no longer in user unless decided otherwise
     * msg,senderID,receiverID
     */
    //String getMessage(int messageID);

    /**
     * @param id the id of the user's info you are changing
     * @param firstName the first name you are trying to set
     * takes the user's id and the firstName and set said user's first name as firstName
     * @return false if failed
     */
    boolean setFirstName(int id, String firstName);

    /**
     * @param id the id of the user's info you are changing
     * @param lastName the last name you are trying to set
     * takes the user's id and the lastName and set said user's last name as lastName
     * @return false if failed
     */
    boolean setLastName(int id, String lastName);

    /**
     * @param id the id of the user's info you are changing
     * @param username the username you are trying to set
     * takes the user's id and the username and set said user's username as username
     * @return false if failed
     */
    boolean setUsername(int id, String username);

    /**
     * @param id the id of the user's info you are changing
     * @param password the password you are trying to set
     * takes the user's id and the password and set said user's password as password
     * @return false if failed
     */
    boolean setPassword(int id, String password);

    /**
     * @param id the id of the user's info you are changing
     * @param gender the gender you are trying to set
     * takes the user's id and the gender and set said user's gender as gender
     * @return false if failed
     */
    boolean setGender(int id, String gender);

    /**
     * @param id the id of the user's info you are changing
     * @param bio the bio you are trying to set
     * takes the user's id and the bio and set said user's bio as bio
     * @return false if failed
     */
    boolean setBio(int id, String bio);

    /**
     * @param id the id of the user's info you are changing
     * @param birthday the birthday you are trying to set
     * takes the user's id and the birthday and set said user's birthday as birthday
     * @return false if failed
     */
    boolean setBirthday(int id, String birthday);

    /**
     * @param id the id of the user's info you are changing
     * @param path the image path you are trying to set
     * takes the user's id and the path and set said user's imgLocation as path
     * @return false if failed
     */
    boolean setImgPath(int id, String path);

    /**
     * @param id the id of the user's info you are changing
     * @param genderPreference the genderPreference you are trying to set
     * takes the user's id and the genderPreference and set said user's gender preference as genderPreference
     * @return false if failed
     */
    boolean setGenderPreference(int id, String genderPreference);

    /**
     * @param currUser the current user id
     * @param likeID the id of the user you are trying to like
     * takes the current user's id and the person they like's id.
     * add the likeID to the currUser's list of likes
     * @return false if failed
     */
    boolean likeUser(int currUser, int likeID);

    /**
     * @param currUser the current user id
     * @param likeID the id of the user you are trying to unlike
     * takes the current user's id and the person they like's id.
     * remove the likeID from the currUser's list of likes
     * @return false if failed
     */
    boolean unlikeUser(int currUser, int likeID);

    /**
     * @param currUser the current user id
     * @param admirerID the id of the user you are trying to admire
     * takes the current user's id and the person they admires' id.
     * add the admirerID to the currUser's list of admires
     * @return false if failed
     */
    boolean admireUser(int currUser, int admirerID);

    /**
     * @param currUser the current user id
     * @param admirerID the id of the user you are trying to stop admire
     * takes the current user's id and the person they admires' id.
     * remove the admirerID from the currUser's list of admires
     * @return false if failed
     */
    boolean stopAdmiringUser(int currUser, int admirerID);

    /**
     * @param userID1 the id of user1
     * @param userID12 the id of user2
     * checks if two user have a thread between them if yes
     * @return the threadID between the two user, if no thread exists return -1
     */
    int checkConversation(int userID1, int userID12);

    /**
     * @param userID1 the id of user1
     * @param userID2 the if of user2
     * takes two users' id and create a thread between them
     * @return -1 if there is already a thread and the threadId if there is no thread between them
     */
    int createThread(int userID1, int userID2);

    /**
     * @param threadID the thread id that the message is in
     * @param sender the id of the sender of the message
     * @param receiver the id of the receiver of the message
     * @param msg the message
     * adds the msg into the given thread id base on the given sender, receiver and threadID.
     */
    void createMessage(int threadID, int sender, int receiver, String msg);

    /**
     * @param id the id of the user you want to generate a list of user matching their gender preference in the database
     * gets of list of id with the required gender base on the gender preference of the parameter id
     * @return an arraylist full of the id of users with the correct gender
     */
    ArrayList<Integer> getSwipeList(int id);

    /**
     * @param lastName the last name of the new user
     * @param firstName the first name of the new user
     * @param password the password of the new user
     * @param username the username of the new user
     * @param age the age of the new user
     * @param gender the gender of the new user
     * @param genderPreference the gender preference of the new user
     * @param birthday the birthday of the new user
     * creates a new user in the database using the parameters below.
     * @returns their PersonID and -1 if invalid parameters are given.
     */
    int createUser(String lastName, String firstName, String password, String username, int age, String gender,
                   String genderPreference);

    void closeDB() throws SQLException;

}
