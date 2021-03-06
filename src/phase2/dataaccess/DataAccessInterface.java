package phase2.dataaccess;

import java.util.ArrayList;
import java.util.Map;

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
     * @return an ArrayList of integers representing the id of user's likes
     */
    ArrayList<Integer> getLikes(int id);

    /**
     * @param id the id of the user's info you are requesting
     * @return an ArrayList of integers representing the id of user's admires
     */
    ArrayList<Integer> getAdmires(int id);

    /**
     * @param id the id of the user's info you are requesting
     * @return an ArrayList of integers representing the id of user's Threads
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

    /**
     * @param id the id of the user
     * @return the user's info in a Map with the keys being the UserInfoConstants
     */
    Map<String, String> getUserInfo(int id);

    /**
     * @param id the if of the user
     * @param info the user's info in a Map with the keys being the UserInfoConstants
     * updates the user's info in the database with info
     */
    void updateUserInfo(int id, Map<String, String> info);

    /**
     * @param currUser the current user id
     * @param likeID the id of the user you are trying to like
     * takes the current user's id and the person they like's id.
     * add the likeID to the currUser's list of likes
     */
    void likeUser(int currUser, int likeID);

    /**
     * @param currUser the current user id
     * @param admirerID the id of the user you are trying to admire
     * takes the current user's id and the person they admires' id.
     * add the admirerID to the currUser's list of admires
     */
    void admireUser(int currUser, int admirerID);

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
     * @param userInfo the user's info in a Map with the keys being the UserInfoConstants without the ImagePath or Bio
     */
    void createUser(Map<String, String> userInfo);

}
