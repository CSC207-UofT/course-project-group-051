package phase2.usecase;

import javafx.scene.image.ImageView;
import phase2.dataaccess.DataAccessInterface;
import phase2.userbuilders.OtherUserBuilder;
import phase2.userbuilders.SelfUserBuilder;
import phase2.userbuilders.UserBuilder;
import phase2.users.OtherUser;
import phase2.users.SelfUser;
import java.util.*;

/**
 * Provides the actions available during swiping.
 */
public class SwipeCase {

    DataAccessInterface db;
    Queue<OtherUser> swipeList;
    SelfUser selfUser;
    public OtherUser currentTarget;


    /**
     * @param db A reference to our Database so we can read and write to it.
     * @param id The ID of the currently logged-in User.
     * @param swipeList A list of IDs of potential users that the current User can swipe on.
     *                  It is assumed there are no repeats, and no already liked Users within the list.
     */
    public SwipeCase(DataAccessInterface db, int id, Queue<Integer> swipeList) {

        this.db = db;

        //Build the current User.
        UserBuilder<SelfUser> selfUserBuilder = new SelfUserBuilder(db, id);
        selfUser = selfUserBuilder.getResult();

        this.swipeList = createSwipeList(swipeList);

        currentTarget = this.swipeList.poll();

    }

    /**
     * @return the nextUser in the list to swipe on, or null if there are none left.
     */
    private OtherUser getNextUser() {

        //Return null if there are none left.

        return swipeList.poll();

    }


    /**
     * @return The ImageView representation of the image associated with the current otherUser.
     */
    public ImageView getImage() {

        return ImageMaker.getImage(currentTarget.getImagePath());

    }

    /**
     * Returns the relevant public info of the current OtherUser.
     * @return a Map containing Age, Bio, fName, and lName, of the current OtherUser.
     */
    public Map<String, String> getData() {

        Map<String, String> userData = new HashMap<>();

        userData.put("Age", currentTarget.getAge());
        userData.put("Bio", currentTarget.getBio());
        userData.put("fName", currentTarget.getfName());
        userData.put("lName", currentTarget.getlName());

        return userData;


    }

    public boolean isEmpty(){
        return currentTarget == null;
    }

    /**
     * Likes the current OtherUser, and determine there are more users to swipe on.
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
     * @return false if there are no more people to swipe on, otherwise true.
     */
    public boolean nextUser() {

        currentTarget = getNextUser();

        return currentTarget != null;

    }


    private Queue<OtherUser> createSwipeList(Queue<Integer> swipeList) {

        Queue<OtherUser> userList = new LinkedList<>();

        for (int user : swipeList) {

            UserBuilder<OtherUser> builder = new OtherUserBuilder(db, user);
            userList.add(builder.getResult());

        }

        return userList;

    }




}
