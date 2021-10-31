package Phase1.DataAccess;


import Phase0.User;

/**
 * An interface that defines the methods that interact with the database.
 */
public interface DataAccessInterface {



    User getProfileUser(int id);

    User getMessageUser(int id);

    User getSwipeUser(int id);

    void UpdateUser(User u);

    void UpdateThread(Thread t);

    Thread getThread(int id);





}
