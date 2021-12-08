package phase2.usecase;

import phase2.userbuilders.PublicUserBuilder;
import phase2.userbuilders.SelfUserBuilder;
import phase2.userbuilders.UserBuilder;
import phase2.users.PublicUser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import phase2.dataaccess.DataAccessInterface;
import phase2.users.SelfUser;

public class SwipeListCase {
    DataAccessInterface db;
    SelfUser currentUser;

    public SwipeListCase(DataAccessInterface db, SelfUser currentUser) {
        this.db = db;
        this.currentUser = currentUser;

        public Queue<PublicUser> filterSwipeList(){

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

        public Queue<PublicUser> createSwipeList(Queue<PublicUser> swipeList) {

            Queue<PublicUser> userList = new LinkedList<>();

            for (int user : swipeList) {

                UserBuilder<PublicUser> builder = new PublicUserBuilder.build(db, user);
                userList.add(builder.getResult());

            }

            return userList;

        }

    }

}

