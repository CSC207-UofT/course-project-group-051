package Phase1.UserActions;

import Phase1.Users.User;

import java.util.Queue;

public class SwipeAction implements Transitionable{

    private int id;
    private Queue<User> potentialUsers;



    public SwipeAction(int id){
        this.id = id;
    }


    public void like(int otherID) {

    }

    public void dislike() {

    }

    public void viewBio(int otherID) {

    }

    public User getNextUser() {
        return null;
    }






    public void transition(){}
}
