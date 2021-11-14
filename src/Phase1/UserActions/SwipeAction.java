package Phase1.UserActions;

import Phase1.DataAccess.DataAccessInterface;
import Phase1.UserBuilders.BuildSwipeUser;
import Phase1.Users.SwipeUser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class SwipeAction implements Transitionable{

    private int currentUser; //User that is swiping
    private Queue<SwipeUser> swipeList; //List of potential matches (filtered)
    private SwipeUser currentTarget; //User currently displayed (null if there are none left)
    private DataAccessInterface db;

    /**
     * Constructs an instance of SwipeAction to allow users to swipe on other users
     * @param currentUser an integer representing the unique ID of the user swiping
     * @param db a DataAccessInterface instance to use the functionality of DataBase
     */
    public SwipeAction(int currentUser, DataAccessInterface db){
        this.currentUser = currentUser;
        this.db = db;

        swipeList = filterSwipeList();
        currentTarget = swipeList.poll();
    }


    /**
     * Likes the current SwipeUser in the database, and returns true if there is a match.
     */
    public boolean like() {

        db.likeUser(currentUser, currentTarget.getId());
        db.admireUser(currentTarget.getId(), currentUser);

        ArrayList<Integer> admirers = db.getAdmires(currentUser);

        return admirers.contains(currentTarget.getId());

    }

    /**
     * This method gets the next user to swipe on from the queue.
     * @return an array representing the data of the next user to swipe on, in the
     * order [fname, lname, age, gender, bio, image], or null if there are none left.
     */
    public String[] getNextUser() {

        currentTarget = swipeList.poll();

        if (currentTarget == null) {
            return null;
        }

        //get currentTarget data.
        String fName = currentTarget.getfName();
        String lName = currentTarget.getlName();
        String age = currentTarget.getAge();
        String gender = currentTarget.getGender();
        String bio = currentTarget.getBio();
        String image = currentTarget.getImagePath();

        //is there a better way to do this kind of list.

        return new String[]{fName, lName, age, gender, bio, image};

    }


    /**
     * Will filter a list of Users from the database to make sure the current User can swipe on them.
     * For example, we will not return any users who were already liked.
     * @return A list of SwipeUsers that are valid for the current User to swipe on.
     */
    private Queue<SwipeUser> filterSwipeList() {

        // Gets a list of people matching the current User's gender preference.
        ArrayList<Integer> unfiltered = db.getSwipeList(currentUser);
        Queue<SwipeUser> filtered = new LinkedList<>();

        // filter these to make sure none of them are already swiped on.
        for (int currUser : unfiltered) {

            // Get the current user's admirers.
            ArrayList<Integer> currentAdmirers = db.getAdmires(currUser);


            //check if the list of admirers contains the currentUser who is swiping.
            //if the currentUser is not on their list, they get added to the swipeList.
            if (!currentAdmirers.contains(currentUser)) {
                BuildSwipeUser builder = new BuildSwipeUser(currUser, db);
                SwipeUser swipeUser = builder.buildUser();
                filtered.add(swipeUser);
            }
        }

        return filtered;


    }






    public void transition(){}
}
