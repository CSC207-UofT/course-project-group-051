package phase2.usecase;

import phase2.dataaccess.DataAccessInterface;
import phase2.users.PublicUser;
import phase2.users.SelfUser;
import java.util.*;

/**
 * Provides the actions available during swiping.
 */
public class SwipeCase {

    private final DataAccessInterface db;
    private final Queue<PublicUser> swipeList;
    private final SelfUser selfUser;
    private PublicUser currentTarget;


    /**
     * @param db          A reference to our Database so we can read and write to it.
     * @param currentUser The currently logged-in User.
     * @param swipeList   A list of IDs of potential users that the current User can swipe on.
     *                    It is assumed there are no repeats, and no already liked Users within the list.
     */
    public SwipeCase(DataAccessInterface db, SelfUser currentUser, Queue<PublicUser> swipeList) {

        this.db = db;

        //Build the current User.
        selfUser = currentUser;
        this.swipeList = swipeList;
        currentTarget = swipeList.poll();

    }

    /**
     * @return the nextUser in the list to swipe on, or null if there are none left.
     */
    private PublicUser getNextUser() {

        //Return null if there are none left.

        return swipeList.poll();

    }


    /**
     * @return The String representation of the image associated with the current otherUser.
     */
    public String getImage() {
        return currentTarget.getImagePath();

    }

    /**
     * Returns the relevant public info of the current OtherUser.
     *
     * @return a Map containing Age, Bio, fName, and lName, of the current OtherUser.
     */
    public Map<String, String> getData() {

        Map<String, String> userData = new HashMap<>();

        userData.put("Age", currentTarget.getAge());
        userData.put("Bio", currentTarget.getBio());
        userData.put("fName", currentTarget.getFirstName());
        userData.put("lName", currentTarget.getLastName());

        return userData;


    }

    /**
     * @return True if there is no one left for the current User to swipe on.
     */
    public boolean isEmpty() {
        return currentTarget == null;
    }

    /**
     * Likes the current OtherUser, and determine there are more users to swipe on.
     */
    public void likeCurrentUser() {

        db.likeUser(selfUser.getId(), currentTarget.getId());
        db.admireUser(currentTarget.getId(), selfUser.getId());

        //Set the target to the next User.
        currentTarget = swipeList.poll();

    }

    /**
     * Goes to the next User, and determines if there are any more Users left to swipe on.
     */
    public void nextUser() {

        currentTarget = getNextUser();

    }
}