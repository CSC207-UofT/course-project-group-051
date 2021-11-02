package Phase1.DataAccess;


import Phase0.User;

/**
 * An interface that defines the methods that interact with the database.
 */
public interface DataAccessInterface {



    User getProfileUser(int id);
    //Make static database.
    //factory

    User getMessageUser(int id);

    User getSwipeUser(int id);

    void UpdateUser(User u); //Bunch of setters that take id and data value.

    void UpdateThread(Thread t);

    Thread getThread(int id);





}
