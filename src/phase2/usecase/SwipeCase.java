package phase2.usecase;

import phase2.dataaccess.DataAccessInterface;
import phase2.userbuilders.SelfUserBuilder;
import phase2.users.PublicUser;
import phase2.users.SelfUser;
import java.util.*;

/**
 * Provides the actions available during swiping.
 */
public class SwipeCase {

    DataAccessInterface db;
    Queue<PublicUser> swipeList;
    SelfUser selfUser;
    public PublicUser currentTarget;


    /**
     * @param db          A reference to our Database so we can read and write to it.
     * @param currentUser The currently logged-in User.
     * @param swipeList   A list of IDs of potential users that the current User can swipe on.
     *                    It is assumed there are no repeats, and no already liked Users within the list.
     */
    public SwipeCase(DataAccessInterface db, SelfUser currentUser, Queue<PublicUser> swipeList) {

        this.db = db;

        //Build the current User.
        this.selfUser = currentUser;

        currentTarget = this.swipeList.poll();

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

    public boolean isEmpty() {
        return currentTarget == null;
    }

    /**
     * Likes the current OtherUser, and determine there are more users to swipe on.
     *
     * @return false if the list is empty.
     */
    public boolean likeCurrentUser() {

        db.likeUser(selfUser.getId(), currentTarget.getId());
        db.admireUser(currentTarget.getId(), selfUser.getId());

        //Set the target to the next User.
        currentTarget = swipeList.poll();

        // check if there is a next User.
        return currentTarget != null;


//        //Check the admirers of the current User for the User they just liked.
//        List<Integer> admirers = db.getAdmires(selfUser.getId());
//
//        //If the User they liked also admires them, then there is a match.
//        return admirers.contains(currentTarget.getId());

    }

    /**
     * Goes to the next User, and determines if there are any more Users left to swipe on.
     *
     * @return false if there are no more people to swipe on, otherwise true.
     */
    public boolean nextUser() {

        currentTarget = getNextUser();

        return currentTarget != null;

    }
}