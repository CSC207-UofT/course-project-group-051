package phase2.usecase;

import phase2.userbuilders.PublicUserBuilder;
import phase2.users.PublicUser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import phase2.dataaccess.DataAccessInterface;
import phase2.users.SelfUser;

/**
 * Has a method which simplifies the creation of a proper swipeList.
 */
public class SwipeListMaker {

    /**
     * Checks the list of potential matches for the currentUser and removes all the people who he already liked.
     * @param db A reference to our database.
     * @param currentUser The currently logged-in user.
     * @return A queue with only Users who have already been liked.
     */
    public static Queue<PublicUser> filterSwipeList(DataAccessInterface db, SelfUser currentUser){
        List<Integer> unfiltered = db.getSwipeList(currentUser.getId());
        Queue<PublicUser> filtered = new LinkedList<>();
        //Loop through the list of unfiltered users
        for (int unfilteredUser : unfiltered) {
            //get all the users who admired the current user we are reviewing
            ArrayList<Integer> currentAdmirers = db.getAdmires(unfilteredUser);
            //if the current SelfUser has already admired this user, then don't include him in the final list.
            if (!currentAdmirers.contains(currentUser.getId())) {
                filtered.add(PublicUserBuilder.build(db, unfilteredUser));
            }
        }
        return filtered;
    }

}

