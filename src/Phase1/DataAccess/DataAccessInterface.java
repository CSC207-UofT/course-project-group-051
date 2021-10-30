package Phase1.DataAccess;


import Phase0.User;

/**
 * An interface that defines the methods that interact with the database.
 */
public interface DataAccessInterface<T extends UserBuilder> {



    User getUser(int ID);

    void UpdateUser(User u);

    void UpdateThread(Thread t);

    Thread getThread(int ID);

}
